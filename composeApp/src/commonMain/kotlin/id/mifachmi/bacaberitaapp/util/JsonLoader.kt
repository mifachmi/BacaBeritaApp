package id.mifachmi.bacaberitaapp.util

import bacaberitaapp.composeapp.generated.resources.Res
import id.mifachmi.bacaberitaapp.data.model.BreakingNews
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
}