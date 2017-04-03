# vertx-tcp-eventbus-bridge

This is a TCP eventbus bridge implementation with SockJSHandler BridgeEvent

    TcpSocketEvent {
      public String type();
      public NetSocket socket() ;
    }

Currently using this library we can get Socket "Open" and "Close" Events with TcpEventBusBridge

## Example

    TcpEventBusBridge bridge = TcpEventBusBridge.create(
      vertx,
      new BridgeOptions()
        .addInboundPermitted(new PermittedOptions().setAddress("in"))
        .addOutboundPermitted(new PermittedOptions().setAddress("out")), null, new Handler<TcpSocketEvent>() {
        @Override
        public void handle(TcpSocketEvent socketEvent) {
            System.out.println("Event : " + socketEvent.type() + " : " + socketEvent.socket().writeHandlerID());
        }
      });

