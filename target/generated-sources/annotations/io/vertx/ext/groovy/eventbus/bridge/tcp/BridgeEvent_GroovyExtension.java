package io.vertx.ext.groovy.eventbus.bridge.tcp;
public class BridgeEvent_GroovyExtension {
  public static <U>io.vertx.core.Future<java.lang.Object> map(io.vertx.ext.eventbus.bridge.tcp.BridgeEvent j_receiver, java.util.function.Function<java.lang.Boolean, java.lang.Object> mapper) {
    return io.vertx.core.impl.ConversionHelper.fromObject(j_receiver.map(mapper != null ? new java.util.function.Function<java.lang.Boolean, java.lang.Object>() {
      public java.lang.Object apply(java.lang.Boolean t) {
        java.lang.Boolean o = t;
        java.lang.Object p = mapper.apply(o);
        return io.vertx.core.impl.ConversionHelper.toObject(p);
      }
    } : null));
  }
  public static io.vertx.ext.eventbus.bridge.tcp.BridgeEvent setRawMessage(io.vertx.ext.eventbus.bridge.tcp.BridgeEvent j_receiver, java.util.Map<String, Object> message) {
    io.vertx.core.impl.ConversionHelper.fromObject(j_receiver.setRawMessage(message != null ? io.vertx.core.impl.ConversionHelper.toJsonObject(message) : null));
    return j_receiver;
  }
}
