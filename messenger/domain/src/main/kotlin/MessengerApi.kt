package dev.oblac.messenger.domain

typealias SendMessage = (Message) -> Unit

data class MessengerApi(
	val sendMessage: SendMessage,
)

data class MessengerModule(
	val sendMessage: () -> SendMessage,
)

fun messengerApi(module: MessengerModule): MessengerApi {
	return MessengerApi(
		sendMessage = { module.sendMessage()(it) },
	)
}