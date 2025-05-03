package dev.oblac.messenger.app.cli

import dev.oblac.messenger.app.SendMessageCli
import dev.oblac.messenger.domain.MessengerModule

fun messengerModule() = MessengerModule (
	sendMessage = { SendMessageCli() },
)