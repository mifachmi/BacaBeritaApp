package id.mifachmi.bacaberitaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.mifachmi.bacaberitaapp.ui.screen.BookmarksScreen
import id.mifachmi.bacaberitaapp.ui.screen.HomeScreen
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier,
    vm: BreakingNewsViewModel
) {
    NavHost(
        navController,
        startDestination = startDestination.route,
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.HOME -> HomeScreen(vm, modifier)
                    Destination.BOOKMARKS -> BookmarksScreen()
                }
            }
        }
    }
}