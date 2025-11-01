package id.mifachmi.bacaberitaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import id.mifachmi.bacaberitaapp.data.local.BookmarkRepository
import id.mifachmi.bacaberitaapp.data.local.DatabaseDriverFactory
import id.mifachmi.bacaberitaapp.database.AppDatabase
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
    vm: BreakingNewsViewModel,
    driverFactory: DatabaseDriverFactory
) {
    // The driverFactory is now provided, not created.
    val bookmarkRepository = remember {
        val driver = driverFactory.createDriver()
        val database = AppDatabase(driver)
        BookmarkRepository(database)
    }

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
            BookmarksScreen(
                bookmarkRepository = bookmarkRepository,
                onOpenDetail = { articleTitle ->
                    navigator.navigate("/detailNews/$articleTitle")
                }
            )
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