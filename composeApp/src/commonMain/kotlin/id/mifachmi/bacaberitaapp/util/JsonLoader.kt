package id.mifachmi.bacaberitaapp.util

import bacaberitaapp.composeapp.generated.resources.Res
import id.mifachmi.bacaberitaapp.data.model.BreakingNews
import kotlinx.serialization.json.Json

val AppJson: Json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
}

class JsonLoader(
    private val json: Json = AppJson
) {
    suspend fun loadBreakingNews(): BreakingNews {
        val bytes = Res.readBytes("files/breaking_news.json")
        val jsonStr = bytes.decodeToString()
        return json.decodeFromString<BreakingNews>(jsonStr)
    }
}