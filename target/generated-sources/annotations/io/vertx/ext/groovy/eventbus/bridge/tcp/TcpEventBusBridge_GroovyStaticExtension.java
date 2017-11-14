package io.vertx.ext.groovy.eventbus.bridge.tcp;
public class TcpEventBusBridge_GroovyStaticExtension {
  public static io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge create(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge j_receiver, io.vertx.core.Vertx vertx, java.util.Map<String, Object> options) {
    return io.vertx.core.impl.ConversionHelper.fromObject(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx,
      options != null ? new io.vertx.ext.bridge.BridgeOptions(io.vertx.core.impl.ConversionHelper.toJsonObject(options)) : null));
  }
  public static io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge create(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge j_receiver, io.vertx.core.Vertx vertx, java.util.Map<String, Object> options, java.util.Map<String, Object> netServerOptions) {
    return io.vertx.core.impl.ConversionHelper.fromObject(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx,
      options != null ? new io.vertx.ext.bridge.BridgeOptions(io.vertx.core.impl.ConversionHelper.toJsonObject(options)) : null,
      netServerOptions != null ? new io.vertx.core.net.NetServerOptions(io.vertx.core.impl.ConversionHelper.toJsonObject(netServerOptions)) : null));
  }
  public static io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge create(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge j_receiver, io.vertx.core.Vertx vertx, java.util.Map<String, Object> options, java.util.Map<String, Object> netServerOptions, io.vertx.core.Handler<io.vertx.ext.eventbus.bridge.tcp.BridgeEvent> eventHandler) {
    return io.vertx.core.impl.ConversionHelper.fromObject(io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge.create(vertx,
      options != null ? new io.vertx.ext.bridge.BridgeOptions(io.vertx.core.impl.ConversionHelper.toJsonObject(options)) : null,
      netServerOptions != null ? new io.vertx.core.net.NetServerOptions(io.vertx.core.impl.ConversionHelper.toJsonObject(netServerOptions)) : null,
      eventHandler != null ? event -> eventHandler.handle(io.vertx.core.impl.ConversionHelper.fromObject(event)) : null));
  }
}
