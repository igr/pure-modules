package dev.oblac.messenger.domain

import java.time.Instant

data class Message(
	val timestamp: Instant,
	val message: String
)
