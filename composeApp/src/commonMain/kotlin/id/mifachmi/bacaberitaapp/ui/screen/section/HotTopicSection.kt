package id.mifachmi.bacaberitaapp.ui.screen.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.mifachmi.bacaberitaapp.ui.component.HotTopicCard
import id.mifachmi.bacaberitaapp.viewmodel.HotTopicViewModel

@Composable
fun HotTopicSection(
    modifier: Modifier,
    vm: HotTopicViewModel
) {
    val news = vm.news.collectAsState().value

    LaunchedEffect(Unit) { vm.load() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalDivider(
            thickness = 8.dp,
            color = Color.LightGray,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            VerticalDivider(
                thickness = 3.dp,
                color = Color.Red,
                modifier = Modifier.height(18.dp)
            )

            news?.section?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 12.dp)
                )
            }
        }

        news?.topics?.forEach { item ->
            HotTopicCard(item)
        }
    }
}