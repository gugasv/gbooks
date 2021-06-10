package pirate.book.data.model

import com.google.gson.annotations.SerializedName

data class BooksResponse (
    @field:SerializedName("items") val books: List<Book>
)