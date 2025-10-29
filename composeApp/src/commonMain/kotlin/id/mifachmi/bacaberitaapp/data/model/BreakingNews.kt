package id.mifachmi.bacaberitaapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreakingNews(
    val headline: String,
    val subheadline: String,
    @SerialName("published_time") val publishedTime: String,
    val articles: List<Article>,
    val source: String
)

@Serializable
data class Article(
    val title: String,
    @SerialName("published_time") val publishedTime: String
)