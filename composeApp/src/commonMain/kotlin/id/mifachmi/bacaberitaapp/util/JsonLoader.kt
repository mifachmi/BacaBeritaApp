package id.mifachmi.bacaberitaapp.util

import bacaberitaapp.composeapp.generated.resources.Res
import id.mifachmi.bacaberitaapp.data.model.BreakingNews
import id.mifachmi.bacaberitaapp.data.model.HotTopics
import id.mifachmi.bacaberitaapp.data.model.LiveReports
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

val AppJson: Json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
}

class JsonLoader(
    private val json: Json = AppJson
) {
    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadBreakingNews(): BreakingNews {
        val bytes = Res.readBytes("files/breaking_news.json")
        val jsonStr = bytes.decodeToString()
        return json.decodeFromString<BreakingNews>(jsonStr)
    }

    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadLiveReportNews(): LiveReports {
        val bytes = Res.readBytes("files/live_report.json")
        val jsonStr = bytes.decodeToString()
        return json.decodeFromString<LiveReports>(jsonStr)
    }

    @OptIn(ExperimentalResourceApi::class)
    suspend fun loadHotTopicsNews(): HotTopics {
        val bytes = Res.readBytes("files/hot_topics.json")
        val jsonStr = bytes.decodeToString()
        return json.decodeFromString<HotTopics>(jsonStr)
    }
}