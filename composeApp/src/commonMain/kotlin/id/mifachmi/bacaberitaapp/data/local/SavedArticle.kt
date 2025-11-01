package id.mifachmi.bacaberitaapp.data.local

import kotlinx.serialization.Serializable

@Serializable
data class SavedArticle(
    val id: String,
    val title: String,
    val publishedTime: String,
    val imageUrl: String? = null,
    val description: String? = null
)

/** Create a stable id from title + publishedTime */
fun stableId(title: String, publishedTime: String): String =
    ("$title|$publishedTime").encodeId()

private fun String.encodeId(): String =
    this.replace("%", "%25").replace("/", "%2F").replace(" ", "%20")