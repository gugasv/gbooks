package pirate.book.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pirate.book.data.model.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM book")
    fun getAll(): Flow<List<Book>>

    @Insert(onConflict = REPLACE)
    fun save(book: Book)

    @Insert
    fun inserAll(vararg books: Book)

    @Delete
    fun delete(book: Book)

}