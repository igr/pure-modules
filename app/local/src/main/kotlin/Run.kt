package dev.oblac.app

import dev.oblac.library.app.libraryModule
import dev.oblac.library.domain.Book
import dev.oblac.library.domain.BookReservation
import dev.oblac.library.domain.LibraryContract
import dev.oblac.library.domain.libraryApi
import dev.oblac.messenger.app.http.messengerModule
import dev.oblac.messenger.domain.Message
import dev.oblac.messenger.domain.messengerApi
import java.time.Instant

/**
 * This is the main entry point of the application.
 */
fun main() {
	// Bootstrap
	// First, we need to instantiate the modules, contract and API.

	// messenger
	val messengerModule = messengerModule()
	val messengerApi = messengerApi(messengerModule)

	// library
	val libraryModule = libraryModule()
	val libraryContract = LibraryContract(  // bridge
		sendNotification = {
			messengerApi.sendMessage(Message(
				timestamp = Instant.now(),
				message = it.message
			))
		},
	)
	val libraryApi = libraryApi(libraryModule, libraryContract)


	// Finally, we can use the application API.

	val book = libraryApi.reserveBook(Book("1984", "George Orwell"))
	println("Reserved book: $book")
	when (book) {
		is BookReservation.ReservedBook -> {
			println("Reserved book: ${book.book}")
			libraryApi.returnBook(book)
		}
		is BookReservation.UnavailableBook -> println("Reservation failed: ${book.reason}")
	}
}