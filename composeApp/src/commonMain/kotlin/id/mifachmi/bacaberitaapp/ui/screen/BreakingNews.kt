package id.mifachmi.bacaberitaapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bacaberitaapp.composeapp.generated.resources.Res
import bacaberitaapp.composeapp.generated.resources.breaking_news
import id.mifachmi.bacaberitaapp.ui.component.ArticleCard
import org.jetbrains.compose.resources.painterResource

@Composable
fun BreakingNews() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.breaking_news),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )

        // Should be list and load data from json
        ArticleCard(isBreakingNews = true)
    }
}