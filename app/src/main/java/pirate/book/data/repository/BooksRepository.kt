package pirate.book.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pirate.book.data.GoogleBooksAPIService
import pirate.book.data.dao.BookDao
import pirate.book.data.model.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BooksRepository @Inject constructor(
    private val localService: BookDao,
    private val remoteService: GoogleBooksAPIService
) {

    suspend fun searchBook(query: String): Flow<List<Book>> =
        withContext(Dispatchers.IO) {
            launch {
                localService.insertAll(remoteService.searchBook(query).books)
            }
            localService.getAll()
        }

}
