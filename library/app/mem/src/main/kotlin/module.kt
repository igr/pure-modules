package dev.oblac.library.app

import dev.oblac.library.domain.LibraryModule

/**
 * This is the main entry point for the library module.
 */
fun libraryModule(): LibraryModule {

	// We need to configure all the internals of the module here.
	// Once when we return the module, it has to be ready to use.
	Db.init()

	return LibraryModule(
		reserveBook = { ReserveBookMem() },
		returnBook = {
			{ sendNotification, bookReservation ->
				returnBookMem(sendNotification, bookReservation)
			}
		},
	)
}
