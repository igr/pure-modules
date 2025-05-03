package dev.oblac.messenger.app.http

import dev.oblac.messenger.domain.Message
import dev.oblac.messenger.domain.SendMessage
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking

fun client() = HttpClient {
    install(ContentNegotiation)
}

class SendMessageHttp : SendMessage {
    override operator fun invoke(message: Message) {
        runBlocking {
            val request = client()
            request.post("http://localhost:8080/send") {
                contentType(ContentType.Application.Json)
                setBody("{\"message\": \"${message.message}\"}")
            }
            request.close()
        }
    }
}