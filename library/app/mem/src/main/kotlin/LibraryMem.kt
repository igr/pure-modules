package dev.oblac.library.app

import dev.oblac.library.domain.*

/**
 * Implementation of a function using classes.
 */
class ReserveBookMem : ReserveBook {
	override operator fun invoke(book: Book): BookReservation {
		return Db.books.find { it.title == book.title }?.let {
			val reservedBook = BookReservation.ReservedBook(it, 10)
			Db.bookReservations.add(reservedBook)
			reservedBook
		} ?: BookReservation.UnavailableBook(book, "Book not available")
	}
}

/**
 * Simple implementation of a function.
 */
fun returnBookMem(
	sendNotification: SendNotification,
	bookReservation: BookReservation.ReservedBook,
) {
	Db.bookReservations.remove(bookReservation)
	val book = bookReservation.book
	val notification = BookNotification(
		book,
		"Book ${book.title} returned",
	)
	sendNotification(notification)
}
