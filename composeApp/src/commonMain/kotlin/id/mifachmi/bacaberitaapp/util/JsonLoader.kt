package id.mifachmi.bacaberitaapp.util

import id.mifachmi.bacaberitaapp.data.model.BreakingNews
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.readResourceBytes

class JsonLoader {
    @OptIn(InternalResourceApi::class)
    suspend fun loadBreakingNews(): BreakingNews {
        val bytes = readResourceBytes("files/breaking_news.json")
        return Json.decodeFromString(bytes.decodeToString())
    }
}