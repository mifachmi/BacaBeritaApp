package id.mifachmi.bacaberitaapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import bacaberitaapp.composeapp.generated.resources.Res
import bacaberitaapp.composeapp.generated.resources.breaking_news
import id.mifachmi.bacaberitaapp.ui.component.ArticleCard
import id.mifachmi.bacaberitaapp.util.rememberShareHandler
import id.mifachmi.bacaberitaapp.viewmodel.BreakingNewsViewModel
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.painterResource

@Composable
fun BreakingNews(
    vm: BreakingNewsViewModel,
    navController: Navigator
) {
    val news = vm.news.collectAsState().value
    val shareHandler = rememberShareHandler()

    val bookmarkedTitles by vm.bookmarkedTitles.collectAsState()

    LaunchedEffect(Unit) { vm.load() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Breaking News Header Image
        Image(
            painter = painterResource(Res.drawable.breaking_news),
            contentDescription = "Breaking News Header",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.size(width = 120.dp, height = 60.dp)
        )

        // Main breaking news article
        news?.let {
            ArticleCard(
                isBreakingNews = true,
                data = it,
                isBookmarked = it.headline in bookmarkedTitles,
                onArticleClick = { article -> navController.navigate("/detailNews/${article.title}") },
                onShareClick = { article -> shareHandler.shareText(article.title, "Bagikan Artikel") },
                onBookmarkClick = { article -> vm.onBookmarkToggled(article) },
                onAudioClick = { article -> print(article.title) }
            )
        }

        news?.articles?.forEach { article ->
            ArticleCard(
                data = news.copy(
                    headline = article.title,
                    publishedTime = article.publishedTime
                ),
                articleData = article,
                isBookmarked = article.title in bookmarkedTitles,
                onArticleClick = { a -> navController.navigate("/detailNews/${a.title}") },
                onShareClick = { article -> shareHandler.shareText(article.title, "Bagikan Artikel") },
                onBookmarkClick = { article -> vm.onBookmarkToggled(article) },
                onAudioClick = { article -> print(article.title) }
            )
        }
    }
}