package id.mifachmi.bacaberitaapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.mifachmi.bacaberitaapp.ui.screen.section.BreakingNewsSection
import id.mifachmi.bacaberitaapp.ui.screen.section.HotTopicSection
import id.mifachmi.bacaberitaapp.ui.screen.section.LiveReportSection
import id.mifachmi.bacaberitaapp.util.JsonLoader
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import id.mifachmi.bacaberitaapp.viewmodel.HotTopicViewModel
import id.mifachmi.bacaberitaapp.viewmodel.LiveReportViewModel
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun HomeScreen(
    navigator: Navigator,
    vm: BreakingNewsViewModel,
    modifier: Modifier
) {
    val liveReportViewModel = remember {
        LiveReportViewModel(
            loader = JsonLoader()
        )
    }

    val hotTopicViewModel = remember {
        HotTopicViewModel(
            loader = JsonLoader()
        )
    }

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

                    LiveReportSection(
                        modifier = Modifier.padding(vertical = 16.dp),
                        vm = liveReportViewModel
                    )
                    // Iframe Campaign
                    // Hot Topics
                    HotTopicSection(
                        modifier = Modifier.padding(vertical = 16.dp),
                        vm = hotTopicViewModel
                    )
                    // Kabinet
                    // PON Aceh
                    // Ads Banner
                    // Bekasi - gaada
                    // Articles
                    // Ads Banner
                }
            }
        }
    }
}