package pirate.book.data.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class BookDeserializer: JsonDeserializer<Book> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Book {
        json as JsonObject

        val id = json.get("id").asString
        val book = json.getAsJsonObject("volumeInfo")
        val title = book.get("title").asString
        val publishedDate = book.get("title").asString
        val thumb = book.get("title").asString

        val authorsArray = book.getAsJsonArray("authors")
        val authors = StringBuilder()
        authorsArray.forEach {
            authors.append(it.asString)
            authors.append(";")
        }

        return Book(id, title, authors.toString(), publishedDate, thumb)
    }
}