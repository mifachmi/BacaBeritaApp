package id.mifachmi.bacaberitaapp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimelineItem(
    timeText: String,
    title: String,
    modifier: Modifier = Modifier,
    dotColor: Color = Color.Red,
    lineColor: Color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
    dotRadius: Dp = 4.dp,
    lineWidth: Dp = 1.dp,
    drawLineBelow: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
    ) {
        // Left rail (dot + dashed line)
        Column(
            modifier = Modifier
                .width(24.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(8.dp))

            // Dot
            Canvas(
                modifier = Modifier
                    .size(dotRadius * 2),
            ) { drawCircle(color = dotColor) }

            // Dashed line (from under the dot to the bottom of this row)
            if (drawLineBelow) {
                val pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f), 0f)
                Canvas(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(lineWidth)
                ) {
                    drawLine(
                        color = lineColor,
                        start = Offset(size.width / 2f, 0f),
                        end = Offset(size.width / 2f, size.height),
                        pathEffect = pathEffect,
                        strokeWidth = lineWidth.toPx()
                    )
                }
            }
        }

        // RIGHT: texts
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(start = 8.dp, top = 0.dp, bottom = 8.dp, end = 8.dp)
                .weight(1f)
        ) {
            Text(
                text = timeText,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}