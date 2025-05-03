package dev.oblac.messenger.service

import dev.oblac.messenger.app.cli.messengerModule
import dev.oblac.messenger.domain.Message
import dev.oblac.messenger.domain.messengerApi
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.Instant

// messenger
val messengerModule = messengerModule()
val messengerApi = messengerApi(messengerModule)

fun main(args: Array<String>) {
	io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
	configureRouting()
}

fun Application.configureRouting() {
	routing {
		post("/send") {
			messengerApi.sendMessage(Message(
				timestamp = Instant.now(),
				message = "Hello from Ktor!"
			))
			call.respondText("Sent!")
		}
	}
}

