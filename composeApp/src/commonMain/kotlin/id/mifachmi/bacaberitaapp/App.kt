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
import id.mifachmi.bacaberitaapp.navigation.AppNavHost
import id.mifachmi.bacaberitaapp.navigation.Destination
import id.mifachmi.bacaberitaapp.util.JsonLoader
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PreComposeApp {
        val navigator = rememberNavigator()
        val startDestination = Destination.HOME
        val vm = remember { BreakingNewsViewModel(loader = JsonLoader()) }

        // Get current route from PreCompose
        val currentEntry by navigator.currentEntry.collectAsState(null)
        // Use the actual route, which might contain parameters (e.g., /detailNews/The-Title)
        val currentRoute = currentEntry?.route?.route

        Scaffold(
            bottomBar = {
                // Corrected Logic: Check if the route STARTS WITH the detail screen's base path.
                // We use a constant for the base path to avoid magic strings.
                val detailScreenBaseRoute = "/detailNews/"
                // We also need to handle the case where currentRoute is null initially.
                if (currentRoute?.startsWith(detailScreenBaseRoute) != true) {
                    NavigationBar(
                        modifier = Modifier.height(90.dp),
                        windowInsets = NavigationBarDefaults.windowInsets,
                    ) {
                        Destination.entries.forEachIndexed { index, destination ->
                            // Use startsWith for selection as well if a destination has sub-routes
                            val isSelected = currentRoute?.startsWith(destination.route) == true
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    navigator.navigate(route = destination.route)
                                },
                                icon = { /* Your Icon Here */ },
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
                vm
            )
        }
    }
}