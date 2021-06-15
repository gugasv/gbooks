package pirate.book.ui.search

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            repository.searchBook("beer").collect {
                _books.postValue(it)
            }
        }
    }



}