package id.mifachmi.bacaberitaapp.ui.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import bacaberitaapp.composeapp.generated.resources.Res
import bacaberitaapp.composeapp.generated.resources.outline_arrow_back_24
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailNewsScreen(navigator: Navigator, article: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // The title in the top app bar is usually empty if you just have navigation
                },
                navigationIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(onClick = { navigator.goBack() }) {
                            Icon(
                                painter = painterResource(Res.drawable.outline_arrow_back_24),
                                contentDescription = "Back"
                            )
                        }
                        Text("Back")
                    }
                },
                // Make TopAppBar transparent
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { contentPadding ->
        // The contentPadding provided by Scaffold automatically handles the space for the TopAppBar.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding) // Apply the padding here
                .padding(horizontal = 16.dp), // Add some horizontal padding for the content
            contentAlignment = Alignment.TopStart // Align content to the top
        ) {
            Text(article)
        }
    }
}