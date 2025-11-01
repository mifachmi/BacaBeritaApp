package id.mifachmi.bacaberitaapp.viewmodel

import id.mifachmi.bacaberitaapp.data.local.SavedArticle
import id.mifachmi.bacaberitaapp.data.model.Article
import id.mifachmi.bacaberitaapp.data.model.BreakingNews
import id.mifachmi.bacaberitaapp.util.JsonLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BreakingNewsViewModel(
    private val loader: JsonLoader,
    val bookmarksViewModel: BookmarksViewModel,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
) {
    private val _news = MutableStateFlow<BreakingNews?>(null)
    val news: StateFlow<BreakingNews?> = _news

    // The UI will collect this from the bookmarksViewModel
    val bookmarkedTitles = bookmarksViewModel.bookmarkedTitles

    fun load() {
        scope.launch {
            _news.value = loader.loadBreakingNews()
        }
    }

    fun onBookmarkToggled(article: Article) {
        scope.launch {
            val isCurrentlyBookmarked = bookmarkedTitles.value.contains(article.title)
            if (isCurrentlyBookmarked) {
                bookmarksViewModel.unbookmark(article.title)
            } else {
                val savedArticle = SavedArticle(
                    id = stableId(article.title, article.publishedTime),
                    title = article.title,
                    publishedTime = article.publishedTime
                )
                bookmarksViewModel.addBookmark(savedArticle)
            }
        }
    }

    // Helper to generate a consistent ID
    fun stableId(title: String, publishedTime: String): String {
        return "${title}_${publishedTime}".hashCode().toString()
    }
}