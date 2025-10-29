package id.mifachmi.bacaberitaapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.mifachmi.bacaberitaapp.ui.screen.BreakingNews
import id.mifachmi.bacaberitaapp.util.JsonLoader
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val vm = remember { BreakingNewsViewModel(loader = JsonLoader()) }

    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    // 📰 Content sections
                    // Navigation Bar
                    // Scrollable Horizontally Tabs
                    BreakingNews(
                        vm = vm
                    )
                    // Live Report
                    // Iframe Campaign
                    // Hot Topics
                    // Kabinet
                    // PON Aceh
                    // Ads Banner
                    // Bekasi - gaada
                    // Articles
                    // Ads Banner
                    // Bottom Navigation
                }
            }
        }
    }
}