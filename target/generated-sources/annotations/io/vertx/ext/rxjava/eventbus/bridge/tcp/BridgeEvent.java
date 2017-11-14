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
import io.vertx.rxjava.ext.bridge.BaseBridgeEvent;
import io.vertx.ext.bridge.BridgeEventType;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.rxjava.core.Future;
import java.util.function.Function;
import io.vertx.rxjava.core.net.NetSocket;

/**
 * Represents an event that occurs on the event bus bridge.
 * <p>
 * Please consult the documentation for a full explanation.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.eventbus.bridge.tcp.BridgeEvent original} non RX-ified interface using Vert.x codegen.
 */

@io.vertx.lang.rxjava.RxGen(io.vertx.ext.eventbus.bridge.tcp.BridgeEvent.class)
public class BridgeEvent extends BaseBridgeEvent {

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BridgeEvent that = (BridgeEvent) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  public static final io.vertx.lang.rxjava.TypeArg<BridgeEvent> __TYPE_ARG = new io.vertx.lang.rxjava.TypeArg<>(
    obj -> new BridgeEvent((io.vertx.ext.eventbus.bridge.tcp.BridgeEvent) obj),
    BridgeEvent::getDelegate
  );

  private final io.vertx.ext.eventbus.bridge.tcp.BridgeEvent delegate;
  
  public BridgeEvent(io.vertx.ext.eventbus.bridge.tcp.BridgeEvent delegate) {
    super(delegate);
    this.delegate = delegate;
  }

  public io.vertx.ext.eventbus.bridge.tcp.BridgeEvent getDelegate() {
    return delegate;
  }

  public Future<Boolean> setHandler(Handler<AsyncResult<Boolean>> arg0) { 
    delegate.setHandler(arg0);
    return this;
  }

  public Single<Boolean> rxSetHandler() { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      setHandler(fut);
    }));
  }

  public void complete(Boolean arg0) { 
    delegate.complete(arg0);
  }

  public boolean tryComplete(Boolean arg0) { 
    boolean ret = delegate.tryComplete(arg0);
    return ret;
  }

  public Boolean result() { 
    Boolean ret = delegate.result();
    return ret;
  }

  public <U> Future<U> compose(Handler<Boolean> handler, Future<U> next) { 
    Future<U> ret = Future.newInstance(delegate.compose(handler, next.getDelegate()), next.__typeArg_0);
    return ret;
  }

  public <U> Future<U> compose(Function<Boolean,Future<U>> mapper) { 
    Future<U> ret = Future.newInstance(delegate.compose(new java.util.function.Function<java.lang.Boolean,io.vertx.core.Future<U>>() {
      public io.vertx.core.Future<U> apply(java.lang.Boolean arg) {
        Future<U> ret = mapper.apply(arg);
        return ret.getDelegate();
      }
    }), io.vertx.lang.rxjava.TypeArg.unknown());
    return ret;
  }

  public <U> Future<U> map(Function<Boolean,U> mapper) { 
    Future<U> ret = Future.newInstance(delegate.map(new java.util.function.Function<java.lang.Boolean,U>() {
      public U apply(java.lang.Boolean arg) {
        U ret = mapper.apply(arg);
        return ret;
      }
    }), io.vertx.lang.rxjava.TypeArg.unknown());
    return ret;
  }

  public Handler<AsyncResult<Boolean>> completer() { 
    if (cached_0 != null) {
      return cached_0;
    }
    Handler<AsyncResult<Boolean>> ret = new Handler<AsyncResult<Boolean>>() {
      public void handle(AsyncResult<Boolean> ar) {
        if (ar.succeeded()) {
          delegate.completer().handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          delegate.completer().handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    };
    cached_0 = ret;
    return ret;
  }

  public Future<Boolean> recover(Function<Throwable,Future<Boolean>> mapper) { 
    Future<Boolean> ret = Future.newInstance(delegate.recover(new java.util.function.Function<java.lang.Throwable,io.vertx.core.Future<java.lang.Boolean>>() {
      public io.vertx.core.Future<java.lang.Boolean> apply(java.lang.Throwable arg) {
        Future<Boolean> ret = mapper.apply(arg);
        return ret.getDelegate();
      }
    }), io.vertx.lang.rxjava.TypeArg.unknown());
    return ret;
  }

  public Future<Boolean> otherwise(Function<Throwable,Boolean> mapper) { 
    Future<Boolean> ret = Future.newInstance(delegate.otherwise(new java.util.function.Function<java.lang.Throwable,java.lang.Boolean>() {
      public java.lang.Boolean apply(java.lang.Throwable arg) {
        Boolean ret = mapper.apply(arg);
        return ret;
      }
    }), io.vertx.lang.rxjava.TypeArg.unknown());
    return ret;
  }

  public Future<Boolean> otherwise(Boolean value) { 
    Future<Boolean> ret = Future.newInstance(delegate.otherwise(value), io.vertx.lang.rxjava.TypeArg.unknown());
    return ret;
  }

  public Future<Boolean> otherwiseEmpty() { 
    Future<Boolean> ret = Future.newInstance(delegate.otherwiseEmpty(), io.vertx.lang.rxjava.TypeArg.unknown());
    return ret;
  }

  /**
   * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
   * no message involved.
   * @param message the raw message
   * @return this reference, so it can be used fluently
   */
  public BridgeEvent setRawMessage(JsonObject message) { 
    delegate.setRawMessage(message);
    return this;
  }

  /**
   * Get the SockJSSocket instance corresponding to the event
   * @return the SockJSSocket instance
   */
  public NetSocket socket() { 
    if (cached_1 != null) {
      return cached_1;
    }
    NetSocket ret = NetSocket.newInstance(delegate.socket());
    cached_1 = ret;
    return ret;
  }

  private Handler<AsyncResult<Boolean>> cached_0;
  private NetSocket cached_1;

  public static  BridgeEvent newInstance(io.vertx.ext.eventbus.bridge.tcp.BridgeEvent arg) {
    return arg != null ? new BridgeEvent(arg) : null;
  }
}
