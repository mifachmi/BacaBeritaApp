package id.mifachmi.bacaberitaapp.data.local

import id.mifachmi.bacaberitaapp.database.AppDatabase

class BookmarkRepository(private val db: AppDatabase) {
    fun getAll(): List<SavedArticle> =
        db.bookmarkQueries.selectAll().executeAsList().map {
            SavedArticle(
                id = it.id,
                title = it.title,
                publishedTime = it.publishedTime,
                imageUrl = it.imageUrl,
                description = it.description
            )
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

    fun removeById(id: String) {
        db.bookmarkQueries.deleteBookmark(id)
    }

    fun removeByTitleAndTime(title: String, publishedTime: String) {
        removeById(stableId(title, publishedTime))
    }
}