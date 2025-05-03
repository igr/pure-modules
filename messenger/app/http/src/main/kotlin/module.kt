package dev.oblac.messenger.app.http

import dev.oblac.messenger.domain.MessengerModule

fun messengerModule(): MessengerModule {
	return MessengerModule(
		sendMessage = { SendMessageHttp() },
	)
}