package dev.oblac.library.app

import dev.oblac.library.domain.Book
import dev.oblac.library.domain.BookReservation

/**
 * Simple DB for the library app.
 */
object Db {
	val books = mutableListOf<Book>()
	val bookReservations = mutableListOf<BookReservation>()

	fun init() {
		books.addAll(
			listOf(
				Book("The Catcher in the Rye", "J.D. Salinger"),
				Book("To Kill a Mockingbird", "Harper Lee"),
				Book("1984", "George Orwell"),
				Book("The Great Gatsby", "F. Scott Fitzgerald"),
			),
		)
		bookReservations.clear()
	}
}