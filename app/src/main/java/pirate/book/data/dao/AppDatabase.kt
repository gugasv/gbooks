package pirate.book.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import pirate.book.data.model.Book

@Database(entities = arrayOf(Book::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

}