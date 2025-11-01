package id.mifachmi.bacaberitaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.mifachmi.bacaberitaapp.ui.screen.BookmarksScreen
import id.mifachmi.bacaberitaapp.ui.screen.HomeScreen
import id.mifachmi.bacaberitaapp.ui.screen.detail.DetailNewsScreen
import id.mifachmi.bacaberitaapp.viewmodel.BookmarksViewModel
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path

@Composable
fun AppNavHost(
    navigator: Navigator,
    startDestination: Destination,
    modifier: Modifier = Modifier,
    vm: BreakingNewsViewModel,
    bookmarksViewModel: BookmarksViewModel,
) {
    // Use the PreCompose NavHost
    NavHost(
        navigator = navigator,
        initialRoute = startDestination.route,
    ) {
        scene(Destination.HOME.route) {
            HomeScreen(navigator, vm, modifier)
        }
        scene(Destination.BOOKMARKS.route) {
            BookmarksScreen(
                bookmarksViewModel = bookmarksViewModel,
                onOpenDetail = { articleTitle ->
                    navigator.navigate("/detailNews/$articleTitle")
                }
            )
        }

        scene(
            route = "/detailNews/{article}"
        ) { backStackEntry ->
            val article = backStackEntry.path<String>("article")
            if (article != null) {
                DetailNewsScreen(navigator, article)
            }
        }
    }
}