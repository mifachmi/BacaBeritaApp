package id.mifachmi.bacaberitaapp.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TimelineList(
    items: List<Pair<String, String>>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items.size) { idx ->
            val (time, title) = items[idx]
            TimelineItem(
                timeText = time,
                title = title,
                drawLineBelow = idx != items.lastIndex
            )
        }
    }
}