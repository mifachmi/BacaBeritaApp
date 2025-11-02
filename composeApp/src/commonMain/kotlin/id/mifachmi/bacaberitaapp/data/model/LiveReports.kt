package id.mifachmi.bacaberitaapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveReports(
    @SerialName("featured_articles")
    val featuredArticles: List<FeaturedArticlesItem?>? = null,

    @SerialName("main_article")
    val mainArticle: MainArticle? = null,

    @SerialName("related_articles")
    val relatedArticles: List<Article?>? = null,

    @SerialName("more_reports")
    val moreReports: MoreReports? = null,

    @SerialName("report_type")
    val reportType: String? = null
)

@Serializable
data class MoreReports(
    @SerialName("count")
    val count: String? = null,

    @SerialName("label")
    val label: String? = null
)

@Serializable
data class MainArticle(

    @SerialName("published_time")
    val publishedTime: String? = null,

    @SerialName("category")
    val category: String? = null,

    @SerialName("title")
    val title: String? = null
)

@Serializable
data class FeaturedArticlesItem(

    @SerialName("title")
    val title: String? = null
)