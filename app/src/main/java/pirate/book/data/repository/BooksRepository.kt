package pirate.book.data.repository

import pirate.book.data.GoogleBooksAPIService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BooksRepository @Inject constructor(
    private val remoteService: GoogleBooksAPIService
) {

    suspend fun searchBook(query: String) = remoteService.searchBook(query)

}