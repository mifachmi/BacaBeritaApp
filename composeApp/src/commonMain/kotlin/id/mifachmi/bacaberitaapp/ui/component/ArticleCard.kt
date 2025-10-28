package id.mifachmi.bacaberitaapp.ui.component

import androidx.compose.foundation.Image
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
import bacaberitaapp.composeapp.generated.resources.ic_share
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArticleCard(
    isBreakingNews: Boolean = false
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Title
        Text(
            text = "Celaka 12! Ini 12 Kisah Pembunuhan dan Pesan di Baliknya",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = if (isBreakingNews) TextAlign.Center else TextAlign.Start,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        )
        // Description
        if (isBreakingNews) {
            Text(
                text = "Kasus Pembunuhan Global: Ekonomi Lemah, Pembunuhan Bertambah",
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
                text = "5 menit lalu",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy((-4).dp)
            ) {
                IconButton(onClick = { println("Button Share clicked") }) {
                    Image(
                        painter = painterResource(Res.drawable.ic_share),
                        contentDescription = "Button Share",
                        modifier = Modifier.size(48.dp)
                    )
                }

                IconButton(onClick = { println("Button Bookmark clicked") }) {
                    Image(
                        painter = painterResource(Res.drawable.ic_bookmark),
                        contentDescription = "Button Bookmark",
                        modifier = Modifier.size(48.dp)
                    )
                }

                IconButton(onClick = { println("Button Audio clicked") }) {
                    Image(
                        painter = painterResource(Res.drawable.ic_audio),
                        contentDescription = "Button Audio",
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }

        if (isBreakingNews) {
            if (isBreakingNews) {
                Image(
                    painter = painterResource(Res.drawable.example),
                    contentDescription = "Banner News",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = if (isBreakingNews) 16.dp else 0.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        )

        if (!isBreakingNews) {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}