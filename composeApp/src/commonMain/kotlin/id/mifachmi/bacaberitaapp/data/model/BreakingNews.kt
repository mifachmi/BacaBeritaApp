package id.mifachmi.bacaberitaapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BreakingNews(
    val headline: String,
    val subheadline: String,
    val publishedTime: String,
    val articles: List<Article>,
    val source: String
)

data class Article(
    val title: String,
    val publishedTime: String,
)