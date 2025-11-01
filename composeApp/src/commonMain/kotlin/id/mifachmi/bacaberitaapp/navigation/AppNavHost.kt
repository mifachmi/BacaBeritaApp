package id.mifachmi.bacaberitaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.mifachmi.bacaberitaapp.ui.screen.BookmarksScreen
import id.mifachmi.bacaberitaapp.ui.screen.HomeScreen
import id.mifachmi.bacaberitaapp.ui.screen.detail.DetailNewsScreen
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path

@Composable
fun AppNavHost(
    // Use the PreCompose Navigator
    navigator: Navigator,
    startDestination: Destination,
    modifier: Modifier = Modifier,
    vm: BreakingNewsViewModel
) {
    // Use the PreCompose NavHost
    NavHost(
        navigator = navigator,
        initialRoute = startDestination.route,
    ) {
        // Main screen destinations
        scene(Destination.HOME.route) {
            // Pass the main navigator into HomeScreen
            HomeScreen(navigator, vm, modifier)
        }
        scene(Destination.BOOKMARKS.route) {
            BookmarksScreen()
        }

        // Add the detail screen destination HERE
        scene(
            // Use the same route pattern as your click handler
            route = "/detailNews/{article}"
        ) { backStackEntry ->
            // Extract the 'article' parameter
            val article = backStackEntry.path<String>("article")
            if (article != null) {
                DetailNewsScreen(navigator, article)
            }
        }
    }
}