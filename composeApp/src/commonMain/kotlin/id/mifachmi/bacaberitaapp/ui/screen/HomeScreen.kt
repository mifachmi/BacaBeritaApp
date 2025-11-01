package id.mifachmi.bacaberitaapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun HomeScreen(
    navigator: Navigator,
    vm: BreakingNewsViewModel,
    modifier: Modifier
) {
    MaterialTheme {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    // 📰 Content sections
                    // Navigation Bar
                    // Scrollable Horizontally Tabs

                    // This NavHost manages the content within the HomeScreen, allowing navigation
                    // from the breaking news list to the detail screen.
                    BreakingNews(
                        vm = vm,
                        navController = navigator
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