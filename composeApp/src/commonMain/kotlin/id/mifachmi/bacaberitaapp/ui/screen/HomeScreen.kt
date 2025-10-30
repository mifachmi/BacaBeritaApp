package id.mifachmi.bacaberitaapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.mifachmi.bacaberitaapp.ui.screen.detail.DetailNewsScreen
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel

@Composable
fun HomeScreen(
    vm: BreakingNewsViewModel,
    modifier: Modifier
) {
    val navController = rememberNavController()

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
//                    BreakingNews(
//                        vm = vm,
//                        navController = navController
//                    )
                    NavHost(navController, startDestination = "breakingNews") {
                        composable("breakingNews") {
                            BreakingNews(vm = vm, navController = navController)
                        }
                        composable(
                            route = "detailNews/{article}",
                            arguments = listOf(
                                navArgument("article") { type = NavType.StringType})
                            ) { backStackEntry ->
                            val article = backStackEntry.arguments.toString()
                            DetailNewsScreen(navController, article) // Pass article
                        }
                    }
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