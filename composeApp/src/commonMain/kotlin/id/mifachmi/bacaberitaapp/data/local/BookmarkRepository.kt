package id.mifachmi.bacaberitaapp.data.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import id.mifachmi.bacaberitaapp.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookmarkRepository(
    private val db: AppDatabase,
    scope: CoroutineScope = CoroutineScope(Dispatchers.Default)
) {
    // Expose a Flow of all saved articles
    val allBookmarks: Flow<List<SavedArticle>> =
        db.bookmarkQueries.selectAll()
            .asFlow()
            .mapToList(scope.coroutineContext)
            .map { articles ->
                articles.map {
                    SavedArticle(
                        id = it.id,
                        title = it.title,
                        publishedTime = it.publishedTime,
                        imageUrl = it.imageUrl,
                        description = it.description
                    )
                }
            }

    fun addOrUpdate(
        title: String,
        publishedTime: String,
        imageUrl: String? = null,
        description: String? = null
    ) {
        val id = stableId(title, publishedTime)
        db.bookmarkQueries.insertBookmark(
            id = id,
            title = title,
            publishedTime = publishedTime,
            imageUrl = imageUrl,
            description = description
        )
    }

    fun removeByTitle(title: String) {
        db.bookmarkQueries.deleteBookmark(title)
    }

    // Helper to generate a consistent ID
    fun stableId(title: String, publishedTime: String): String {
        return "${title}_${publishedTime}".hashCode().toString()
    }
}