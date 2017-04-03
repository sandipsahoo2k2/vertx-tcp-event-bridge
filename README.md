# vertx-tcp-eventbus-bridge

This is a modfied TCP eventbus bridge implementation with TcpSocketEvent similar to the SockJSHandler BridgeEvent

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

## Note

Refer: https://github.com/vert-x3/vertx-tcp-eventbus-bridge for the actual implementations.
I modified java library solely for my project where I had to listen to Socket Open and Close events as well with existing TcpEventBusBridge
