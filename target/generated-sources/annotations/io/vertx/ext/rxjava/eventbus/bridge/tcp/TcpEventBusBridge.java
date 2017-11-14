/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.ext.rxjava.eventbus.bridge.tcp;

import java.util.Map;
import rx.Observable;
import rx.Single;
import io.vertx.core.net.NetServerOptions;
import io.vertx.rxjava.core.Vertx;
import io.vertx.ext.bridge.BridgeOptions;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * TCP EventBus bridge for Vert.x
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge original} non RX-ified interface using Vert.x codegen.
 */

@io.vertx.lang.rxjava.RxGen(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.class)
public class TcpEventBusBridge {

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TcpEventBusBridge that = (TcpEventBusBridge) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  public static final io.vertx.lang.rxjava.TypeArg<TcpEventBusBridge> __TYPE_ARG = new io.vertx.lang.rxjava.TypeArg<>(
    obj -> new TcpEventBusBridge((io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge) obj),
    TcpEventBusBridge::getDelegate
  );

  private final io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge delegate;
  
  public TcpEventBusBridge(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge delegate) {
    this.delegate = delegate;
  }

  public io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge getDelegate() {
    return delegate;
  }

  public static TcpEventBusBridge create(Vertx vertx) { 
    TcpEventBusBridge ret = TcpEventBusBridge.newInstance(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.getDelegate()));
    return ret;
  }

  public static TcpEventBusBridge create(Vertx vertx, BridgeOptions options) { 
    TcpEventBusBridge ret = TcpEventBusBridge.newInstance(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.getDelegate(), options));
    return ret;
  }

  public static TcpEventBusBridge create(Vertx vertx, BridgeOptions options, NetServerOptions netServerOptions) { 
    TcpEventBusBridge ret = TcpEventBusBridge.newInstance(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.getDelegate(), options, netServerOptions));
    return ret;
  }

  public static TcpEventBusBridge create(Vertx vertx, BridgeOptions options, NetServerOptions netServerOptions, Handler<BridgeEvent> eventHandler) { 
    TcpEventBusBridge ret = TcpEventBusBridge.newInstance(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx.getDelegate(), options, netServerOptions, new Handler<io.vertx.ext.eventbus.bridge.tcp.BridgeEvent>() {
      public void handle(io.vertx.ext.eventbus.bridge.tcp.BridgeEvent event) {
        eventHandler.handle(BridgeEvent.newInstance(event));
      }
    }));
    return ret;
  }

  /**
   * Listen on default port 7000
   * @return self
   */
  public TcpEventBusBridge listen() { 
    delegate.listen();
    return this;
  }

  /**
   * Listen on default port 7000 with a handler to report the state of the socket listen operation.
   * @param handler the result handler
   * @return self
   */
  public TcpEventBusBridge listen(Handler<AsyncResult<TcpEventBusBridge>> handler) { 
    delegate.listen(new Handler<AsyncResult<io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge>>() {
      public void handle(AsyncResult<io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(TcpEventBusBridge.newInstance(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    });
    return this;
  }

  /**
   * Listen on default port 7000 with a handler to report the state of the socket listen operation.
   * @return 
   */
  public Single<TcpEventBusBridge> rxListen() { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      listen(fut);
    }));
  }

  /**
   * Listen on specific port and bind to specific address
   * @param port tcp port
   * @param address tcp address to the bind
   * @return self
   */
  public TcpEventBusBridge listen(int port, String address) { 
    delegate.listen(port, address);
    return this;
  }

  /**
   * Listen on specific port and bind to specific address
   * @param port tcp port
   * @param address tcp address to the bind
   * @param handler the result handler
   * @return self
   */
  public TcpEventBusBridge listen(int port, String address, Handler<AsyncResult<TcpEventBusBridge>> handler) { 
    delegate.listen(port, address, new Handler<AsyncResult<io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge>>() {
      public void handle(AsyncResult<io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(TcpEventBusBridge.newInstance(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    });
    return this;
  }

  /**
   * Listen on specific port and bind to specific address
   * @param port tcp port
   * @param address tcp address to the bind
   * @return 
   */
  public Single<TcpEventBusBridge> rxListen(int port, String address) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      listen(port, address, fut);
    }));
  }

  /**
   * Listen on specific port
   * @param port tcp port
   * @return self
   */
  public TcpEventBusBridge listen(int port) { 
    delegate.listen(port);
    return this;
  }

  /**
   * Listen on specific port
   * @param port tcp port
   * @param handler the result handler
   * @return self
   */
  public TcpEventBusBridge listen(int port, Handler<AsyncResult<TcpEventBusBridge>> handler) { 
    delegate.listen(port, new Handler<AsyncResult<io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge>>() {
      public void handle(AsyncResult<io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(TcpEventBusBridge.newInstance(ar.result())));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    });
    return this;
  }

  /**
   * Listen on specific port
   * @param port tcp port
   * @return 
   */
  public Single<TcpEventBusBridge> rxListen(int port) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      listen(port, fut);
    }));
  }

  /**
   * Close the current socket.
   * @param handler the result handler
   */
  public void close(Handler<AsyncResult<Void>> handler) { 
    delegate.close(handler);
  }

  /**
   * Close the current socket.
   * @return 
   */
  public Single<Void> rxClose() { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      close(fut);
    }));
  }

  /**
   * Close the current socket.
   */
  public void close() { 
    delegate.close();
  }


  public static  TcpEventBusBridge newInstance(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge arg) {
    return arg != null ? new TcpEventBusBridge(arg) : null;
  }
}
