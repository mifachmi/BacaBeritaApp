package id.mifachmi.bacaberitaapp.ui.screen.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bacaberitaapp.composeapp.generated.resources.Res
import bacaberitaapp.composeapp.generated.resources.example
import bacaberitaapp.composeapp.generated.resources.ic_share
import id.mifachmi.bacaberitaapp.ui.component.LiveReportCard
import id.mifachmi.bacaberitaapp.ui.component.TimelineList
import id.mifachmi.bacaberitaapp.viewmodel.LiveReportViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun LiveReportSection(
    modifier: Modifier,
    vm: LiveReportViewModel
) {
    val news = vm.news.collectAsState().value

    LaunchedEffect(Unit) { vm.load() }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // Image Header
        Box {
            Image(
                painter = painterResource(Res.drawable.example),
                contentDescription = news?.mainArticle?.title,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            ) {
                news?.reportType?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            news?.mainArticle?.category?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    color = Color.Red
                )
            }

            news?.mainArticle?.title?.let {
                Text(
                    text = it,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                )
            }

            news?.mainArticle?.publishedTime?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
            }

            val relatedArticles = news?.relatedArticles?.mapNotNull { article ->
                if (article?.title != null) {
                    Pair(article.publishedTime, article.title)
                } else {
                    null
                }
            }

            if (relatedArticles != null) {
                TimelineList(
                    items = relatedArticles,
                    modifier = Modifier.height(180.dp).padding(vertical = 4.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    news?.moreReports?.label?.let {
                        Text(
                            text = it,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    news?.moreReports?.count?.let {
                        Text(
                            text = it,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.Red)
                                .padding(horizontal = 16.dp)
                        )
                    }
                }

                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(Res.drawable.ic_share),
                        contentDescription = "Button Share",
                        modifier = Modifier.size(48.dp)
                    )
                }
            }

            news?.featuredArticles?.forEach { articlesItem ->
                if (articlesItem != null) {
                    LiveReportCard(articlesItem = articlesItem)
                }
            }
        }
    }
}