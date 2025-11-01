package id.mifachmi.bacaberitaapp

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.mifachmi.bacaberitaapp.data.local.BookmarkRepository
import id.mifachmi.bacaberitaapp.database.AppDatabase
import id.mifachmi.bacaberitaapp.di.createDriverFactory
import id.mifachmi.bacaberitaapp.navigation.AppNavHost
import id.mifachmi.bacaberitaapp.navigation.Destination
import id.mifachmi.bacaberitaapp.util.JsonLoader
import id.mifachmi.bacaberitaapp.viewmodel.BookmarksViewModel
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PreComposeApp {
        // setup navigation
        val navigator = rememberNavigator()
        val startDestination = Destination.HOME

        // setup database and repositories
        val driverFactory = createDriverFactory()
        val database = remember { AppDatabase(driverFactory.createDriver()) }

        val bookmarkRepository = remember { BookmarkRepository(db = database) }

        // setup view models
        val bookmarksViewModel = remember { BookmarksViewModel(bookmarkRepository) }
        val vm = remember {
            BreakingNewsViewModel(
                loader = JsonLoader(),
                bookmarksViewModel = bookmarksViewModel
            )
        }

        // get current route
        val currentEntry by navigator.currentEntry.collectAsState(null)
        val currentRoute = currentEntry?.route?.route

        Scaffold(
            bottomBar = {
                val detailScreenBaseRoute = "/detailNews/"
                if (currentRoute?.startsWith(detailScreenBaseRoute) != true) {
                    NavigationBar(
                        modifier = Modifier.height(90.dp),
                        windowInsets = NavigationBarDefaults.windowInsets,
                    ) {
                        Destination.entries.forEachIndexed { index, destination ->
                            val isSelected = currentRoute?.startsWith(destination.route) == true
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    navigator.navigate(route = destination.route)
                                },
                                icon = { },
                                label = { Text(destination.label) }
                            )
                        }
                    }
                }
            }
        ) { contentPadding ->
            AppNavHost(
                navigator,
                startDestination,
                Modifier.padding(contentPadding),
                vm,
                bookmarksViewModel
            )
        }
    }
}