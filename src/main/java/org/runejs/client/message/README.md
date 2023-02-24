# Message system

Messages represent a packet sent from the server to the client (`InboundMessage`), or from the client to the server (`OutboundMessage`). The message is a domain object that represents the data sent in the packet, rather than the bytes themselves.

The [codec system](../net/codec/README.md) is responsible for converting the bytes into a message, and vice versa.

Messages have [message handlers](./handler/README.md) which are responsible for applying `InboundMessages` to the game state.