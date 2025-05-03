package dev.oblac.messenger.app

import dev.oblac.messenger.domain.Message
import dev.oblac.messenger.domain.SendMessage

class SendMessageCli : SendMessage {
	override operator fun invoke(message: Message) {
		println("📮 ${message.message}")
	}
}