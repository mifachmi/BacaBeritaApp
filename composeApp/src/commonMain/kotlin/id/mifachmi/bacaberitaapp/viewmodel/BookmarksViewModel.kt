package id.mifachmi.bacaberitaapp.viewmodel

import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import id.mifachmi.bacaberitaapp.data.local.BookmarkRepository
import id.mifachmi.bacaberitaapp.data.local.SavedArticle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookmarksViewModel(private val bookmarkRepository: BookmarkRepository) :
    ViewModel() {

    private val _items = MutableStateFlow<List<SavedArticle>>(emptyList())
    val items = _items.asStateFlow()

    fun load() {
        // 3. Use viewModelScope for coroutines
        viewModelScope.launch {
            _items.value = bookmarkRepository.getAll()
        }
    }

    fun unbookmark(id: String) {
        viewModelScope.launch {
            bookmarkRepository.removeById(id)
            load() // Reload the list after removing an item
        }
    }
}