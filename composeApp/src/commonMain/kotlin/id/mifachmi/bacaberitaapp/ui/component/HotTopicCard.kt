package id.mifachmi.bacaberitaapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bacaberitaapp.composeapp.generated.resources.Res
import bacaberitaapp.composeapp.generated.resources.example
import bacaberitaapp.composeapp.generated.resources.outline_arrow_forward_ios_24
import id.mifachmi.bacaberitaapp.data.model.TopicsItem
import org.jetbrains.compose.resources.painterResource

@Composable
fun HotTopicCard(
    article: TopicsItem
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .border(
                width = 1.5.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.example),
                contentDescription = article.imageDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(65.dp)
                    .clipToBounds()
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = article.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .weight(1f)
            )

            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(Res.drawable.outline_arrow_forward_ios_24),
                    contentDescription = "Button Click Detail",
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
            }
        }
    }
}