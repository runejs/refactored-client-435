# Message system

Messages represent a packet sent from the server to the client (`InboundMessage`), or from the client to the server (`OutboundMessage`). The message is a domain object that represents the data sent in the packet, rather than the bytes themselves.

The [codec system](../net/codec/README.md) is responsible for converting the bytes into a message, and vice versa.

Messages have [message handlers](./handler/README.md) which are responsible for applying `InboundMessages` to the game state.

## Creating a new `InboundMessage`

To create a new `InboundMessage`, i.e. to receive a new packet from the server, you need to do the following:

- Create a new class that implements `InboundMessage`
    - use this class as `TMessage` in the following steps
- Create a new class that implements `MessageHandler<TMessage>`
    - the `handle` method is responsible for applying the message to the game state
- Register the message handler in your existing `MessageHandlerRegistry`
- Create a new class that implements `MessageDecoder<TMessage>`
    - the `decode` method is responsible for converting the bytes of the packet into your `TMessage`
- Register the message decoder in your existing `MessagePacketCodec`

Your packet will now be received from the server and handled by your `MessageHandler`.

## Creating a new `OutboundMessage`

To create a new `OutboundMessage`, i.e. to send a new packet to the server, you need to do the following:

- Create a new class that implements `OutboundMessage`
    - use this class as `TMessage` in the following steps
- Create a new class that implements `MessageEncoder<TMessage>`
    - the `encode` method is responsible for converting your `TMessage` into the bytes of the packet
- Register the message encoder in your existing `MessagePacketCodec`

You can send your packet to the server by calling `OutgoingPackets.sendMessage` with your `TMessage` as the argument:

```java
OutgoingPackets.sendMessage(new MyNewOutboundMessage("your", "message", "arguments"));
```