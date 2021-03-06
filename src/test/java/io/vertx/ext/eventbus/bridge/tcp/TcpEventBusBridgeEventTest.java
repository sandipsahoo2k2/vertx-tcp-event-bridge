/*
 * Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.ext.eventbus.bridge.tcp;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.net.*;
import io.vertx.ext.bridge.BridgeOptions;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.eventbus.bridge.tcp.impl.protocol.FrameHelper;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

@RunWith(VertxUnitRunner.class)
public class TcpEventBusBridgeEventTest {

  private Vertx vertx;

  @Before
  public void before(TestContext context) {
    vertx = Vertx.vertx();
    final Async async = context.async();

    vertx.eventBus().consumer("hello", (Message<JsonObject> msg) -> msg.reply(new JsonObject().put("value", "Hello " + msg.body().getString("value"))));

    vertx.eventBus().consumer("echo", (Message<JsonObject> msg) -> msg.reply(msg.body()));

    vertx.setPeriodic(1000, __ -> vertx.eventBus().send("ping", new JsonObject().put("value", "hi")));

    TcpEventBusBridge bridge = TcpEventBusBridge.create(
      vertx,
      new BridgeOptions()
        .addInboundPermitted(new PermittedOptions().setAddress("hello"))
        .addInboundPermitted(new PermittedOptions().setAddress("echo"))
        .addInboundPermitted(new PermittedOptions().setAddress("test"))
        .addOutboundPermitted(new PermittedOptions().setAddress("echo"))
        .addOutboundPermitted(new PermittedOptions().setAddress("ping")),
      new NetServerOptions()
        .setSsl(true).setTrustStoreOptions(new JksOptions().setPath("server.truststore").setPassword("wibble"))
        .setKeyStoreOptions(new JksOptions().setPath("server.keystore").setPassword("wibble")),
      be -> {

        Logger l = LoggerFactory.getLogger(this.getClass().getName());
        l.info("Handled a bridge event : " +  be.type() + " body : " + be.getRawMessage());
        if (be.socket().isSsl()) {
          try {
            for (X509Certificate c : be.socket().peerCertificateChain()) {
              l.info(c.getSubjectDN().toString());
            }

          } catch (SSLPeerUnverifiedException e) {
            l.warn("Caught SSLPeerUnverifiedException when processing peerCertificateChain ");
            //@fixme should have a test truststore/keystore that validates, the ones i made still throw this
          }
        }

        be.complete(true);

      });

    bridge.listen(7000, res -> {
      context.assertTrue(res.succeeded());
      async.complete();
    });
  }

  @After
  public void after(TestContext context) {
    vertx.close(context.asyncAssertSuccess());
  }

  @Test
  public void testSendVoidMessage(TestContext context) {
    // Send a request and get a response
    NetClient client = vertx.createNetClient(new NetClientOptions().setSsl(true).setTrustAll(true)
      .setKeyStoreOptions(new JksOptions().setPath("client.keystore").setPassword("wibble")));
    final Async async = context.async();

    vertx.eventBus().consumer("test", (Message<JsonObject> msg) -> {
      client.close();
      async.complete();
    });

    client.connect(7000, "localhost", conn -> {
      context.assertFalse(conn.failed());

      NetSocket socket = conn.result();

      FrameHelper.sendFrame("send", "test", new JsonObject().put("value", "vert.x"), socket);
      try {
        TimeUnit.SECONDS.sleep(4);

      FrameHelper.sendFrame("ping", "hi", new JsonObject().put("value", "vert.x"), socket);

        TimeUnit.SECONDS.sleep(2);

        FrameHelper.sendFrame("ping", "hi", new JsonObject().put("value", "vert.x"), socket);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }

}
