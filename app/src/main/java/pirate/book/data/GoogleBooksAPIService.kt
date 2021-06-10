package pirate.book.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pirate.book.data.model.Book
import pirate.book.data.model.BookDeserializer
import pirate.book.data.model.BooksResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksAPIService {

    @GET("volumes")
    suspend fun searchBook(@Query("q") query: String): BooksResponse

    companion object {
        private const val BASE_URL = "https://www.googleapis.com/books/v1/"

        fun create(): GoogleBooksAPIService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            val bookDeserializer = GsonBuilder().registerTypeAdapter(Book::class.java, BookDeserializer()).create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(bookDeserializer))
                .build()
                .create(GoogleBooksAPIService::class.java)
        }
    }

}