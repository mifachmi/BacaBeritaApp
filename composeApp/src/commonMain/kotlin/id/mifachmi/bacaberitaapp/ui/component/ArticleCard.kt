package id.mifachmi.bacaberitaapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bacaberitaapp.composeapp.generated.resources.Res
import bacaberitaapp.composeapp.generated.resources.example
import bacaberitaapp.composeapp.generated.resources.ic_audio
import bacaberitaapp.composeapp.generated.resources.ic_bookmark
import bacaberitaapp.composeapp.generated.resources.ic_bookmark_filled
import bacaberitaapp.composeapp.generated.resources.ic_share
import id.mifachmi.bacaberitaapp.data.model.Article
import id.mifachmi.bacaberitaapp.data.model.BreakingNews
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArticleCard(
    isBreakingNews: Boolean = false,
    data: BreakingNews,
    articleData: Article? = null,
    isBookmarked: Boolean = false,
    onArticleClick: (Article) -> Unit,
    onShareClick: (Article) -> Unit,
    onBookmarkClick: (Article) -> Unit,
    onAudioClick: (Article) -> Unit
) {
    val article = if (isBreakingNews) Article(
        title = data.headline,
        publishedTime = data.publishedTime
    ) else articleData

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { article?.let { onArticleClick(it) } },
    ) {
        // Title
        Text(
            text = articleData?.title ?: data.headline,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = if (isBreakingNews) TextAlign.Center else TextAlign.Start,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )

        // Description
        if (isBreakingNews) {
            Text(
                text = data.subheadline,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Action Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = articleData?.publishedTime ?: data.publishedTime,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy((-4).dp)
            ) {
                IconButton(onClick = { article?.let { data -> onShareClick(data) } }) {
                    Image(
                        painter = painterResource(Res.drawable.ic_share),
                        contentDescription = "Button Share",
                        modifier = Modifier.size(48.dp)
                    )
                }

                IconButton(onClick = { article?.let { data -> onBookmarkClick(data) } }) {
                    val bookmarkIcon = if (isBookmarked) {
                        Res.drawable.ic_bookmark_filled
                    } else {
                        Res.drawable.ic_bookmark
                    }
                    Image(
                        painter = painterResource(bookmarkIcon),
                        contentDescription = "Button Bookmark",
                        modifier = Modifier.size(48.dp)
                    )
                }

                IconButton(onClick = { article?.let { data -> onAudioClick(data) } }) {
                    Image(
                        painter = painterResource(Res.drawable.ic_audio),
                        contentDescription = "Button Audio",
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }

        if (isBreakingNews) {
            Image(
                painter = painterResource(Res.drawable.example),
                contentDescription = "Banner News",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = if (isBreakingNews) 16.dp else 0.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        )
    }
}