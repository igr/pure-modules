package dev.oblac.library.domain

sealed class BookReservation {

	data class ReservedBook(
		val book: Book,
		val reservedUntil: Long
	) : BookReservation()

	data class UnavailableBook(
		val book: Book,
		val reason: String
	) : BookReservation()

}