package dev.oblac.library.domain


/**
 * API definition, used by clients.
 */

typealias ReserveBook = (Book) -> BookReservation
typealias ReturnBook = (BookReservation.ReservedBook) -> Unit

data class LibraryApi(
	val reserveBook: ReserveBook,
	val returnBook: ReturnBook
)

/**
 * Contract definition that needs to be satisfied.
 */

typealias SendNotification = (BookNotification) -> Unit

data class LibraryContract(
	val sendNotification: SendNotification
)

/**
 * Finally, Module definition. Its functions have
 * complete signatures.
 * @see [libraryApi]
 */
data class LibraryModule(
	val reserveBook: () -> ReserveBook,
	val returnBook: () -> (SendNotification, BookReservation.ReservedBook) -> Unit,
)

/**
 * Curry the module with the contract to create the API.
 */
fun libraryApi(module: LibraryModule, contract: LibraryContract): LibraryApi {
	return LibraryApi(
		reserveBook = { module.reserveBook()(it) },
		returnBook = { bookReservation ->
			val sendNotification = contract.sendNotification
			module.returnBook()(sendNotification, bookReservation)
		},
	)
}