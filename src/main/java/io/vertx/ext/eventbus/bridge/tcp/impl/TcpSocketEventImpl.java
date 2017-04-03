package io.vertx.ext.eventbus.bridge.tcp.impl;

import io.vertx.core.net.NetSocket;
import io.vertx.ext.eventbus.bridge.tcp.TcpSocketEvent;

/**
 * TCP Sock Event Vert.x
 *
 * @author <a href="mailto:sandipsahoo2k2@gmail.com">Sandeep Sahoo</a>
 */
public class TcpSocketEventImpl implements TcpSocketEvent {
  String type;
  NetSocket socket;

  public String type()
  {
    return this.type;
  }

  public NetSocket socket() {
    return this.socket;
  }

  public TcpSocketEventImpl(String type, NetSocket socket)
  {
    this.type = type;
    this.socket = socket;
  }
}
