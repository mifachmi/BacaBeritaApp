package id.mifachmi.bacaberitaapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import bacaberitaapp.composeapp.generated.resources.Res
import bacaberitaapp.composeapp.generated.resources.breaking_news
import id.mifachmi.bacaberitaapp.ui.component.ArticleCard
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun BreakingNews(
    vm: BreakingNewsViewModel,
    navController: NavController
) {
    val news = vm.news.collectAsState().value
    LaunchedEffect(Unit) { vm.load() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.breaking_news),
            contentDescription = "App Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.size(width = 120.dp, height = 60.dp)
        )

        news?.let {
            ArticleCard(
                isBreakingNews = true,
                data = it,
                onArticleClick = { article -> navController.navigate("detailNews/${article}") },
                onShareClick = {article -> print(article.title)},
                onBookmarkClick = {article -> print(article.title)},
                onAudioClick = {article -> print(article.title)},
            )
        }

        news?.articles?.forEach { article ->
            ArticleCard(
                data = news.copy(
                    headline = article.title,
                    publishedTime = article.publishedTime
                ),
                articleData = article,
                onArticleClick = { article -> print(article.title) },
                onShareClick = { article -> print(article.title) },
                onBookmarkClick = { article -> print(article.title) },
                onAudioClick = { article -> print(article.title) },
            )
        }
    }
}