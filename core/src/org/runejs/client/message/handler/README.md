# Inbound message handlers

Inbound message handlers are responsible for applying `InboundMessages` to the game state. They are registered with a `MessageHandlerRegistry`, and are invoked when a new message is received from the server.

## Creating a new handler

First, create your `MessageHandler` to handle the message:

```java
public class MyInboundMessageHandler implements MessageHandler<MyInboundMessage> {
    @Override
    public void handle(MyInboundMessage message) {
        // Handle the message
    }
}
```

Then, register it with the `MessageHandlerRegistry`:

```java
public class MyMessageHandlerRegistry extends MessageHandlerRegistry {
    public MyMessageHandlerRegistry() {
        super();
        register(MyInboundMessage.class, new MyInboundMessageHandler());
    }
}
```