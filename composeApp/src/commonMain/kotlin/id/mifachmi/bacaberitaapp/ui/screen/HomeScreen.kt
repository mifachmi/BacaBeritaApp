package id.mifachmi.bacaberitaapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.mifachmi.bacaberitaapp.ui.screen.section.BreakingNewsSection
import id.mifachmi.bacaberitaapp.ui.screen.section.LiveReportSection
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
                    BreakingNewsSection(
                        vm = vm,
                        navController = navigator
                    )
                    // Live Report
                    LiveReportSection(
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
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