package id.mifachmi.bacaberitaapp.viewmodel

import id.mifachmi.bacaberitaapp.data.model.BreakingNews
import id.mifachmi.bacaberitaapp.util.JsonLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BreakingNewsViewModel(
    private val loader: JsonLoader,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
) {
    private val _news = MutableStateFlow<BreakingNews?>(null)
    val news: StateFlow<BreakingNews?> = _news

    fun load() {
        scope.launch {
            _news.value = loader.loadBreakingNews()
        }
    }
}