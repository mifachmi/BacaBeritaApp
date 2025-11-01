package id.mifachmi.bacaberitaapp.viewmodel

import id.mifachmi.bacaberitaapp.data.local.BookmarkRepository
import id.mifachmi.bacaberitaapp.data.local.SavedArticle
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class BookmarksViewModel(private val bookmarkRepository: BookmarkRepository) :
    ViewModel() {

    // This StateFlow holds the complete list of bookmarked articles
    val bookmarkedArticles: StateFlow<List<SavedArticle>> = bookmarkRepository.allBookmarks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    // A StateFlow that holds only the titles of bookmarked articles for quick lookups
    val bookmarkedTitles: StateFlow<Set<String>> = bookmarkRepository.allBookmarks
        .map { articles -> articles.map { it.title }.toSet() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptySet()
        )

    fun addBookmark(article: SavedArticle) {
        viewModelScope.launch {
            bookmarkRepository.addOrUpdate(
                title = article.title,
                publishedTime = article.publishedTime,
                imageUrl = article.imageUrl,
                description = article.description
            )
        }
    }

    fun unbookmark(title: String) {
        viewModelScope.launch {
            bookmarkRepository.removeByTitle(title)
        }
    }
}