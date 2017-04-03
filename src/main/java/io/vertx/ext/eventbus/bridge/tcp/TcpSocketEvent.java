package io.vertx.ext.eventbus.bridge.tcp;

import io.vertx.codegen.annotations.CacheReturn;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.NetSocket;
import io.vertx.ext.bridge.BridgeOptions;
import io.vertx.ext.eventbus.bridge.tcp.impl.TcpEventBusBridgeImpl;

/**
 * TCP Sock Event Vert.x
 *
 * @author <a href="mailto:sandipsahoo2k2@gmail.com">Sandeep Sahoo</a>
 */
public interface TcpSocketEvent {
  public String type();
  public NetSocket socket() ;
}
