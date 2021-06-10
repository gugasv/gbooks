package pirate.book.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pirate.book.data.model.Book
import pirate.book.data.repository.BooksRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject internal constructor(
    private val repository: BooksRepository
) : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    init {
        viewModelScope.launch {
            _books.value = repository.searchBook("beer").books
        }
    }

}