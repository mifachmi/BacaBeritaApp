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
import org.jetbrains.compose.resources.painterResource

@Composable
fun LiveReportSection(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // Image Header
        Box {
            Image(
                painter = painterResource(Res.drawable.example),
                contentDescription = "Live Report Header",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Reportase Langsung",
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
            }
        }

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Ini Text Kampanye",
                fontSize = 12.sp,
                color = Color.Red
            )

            Text(
                text = "articleData?.title ?: data.headline",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
            )

            Text(
                text = "1 menit yang lalu",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )

            TimelineList(
                items = listOf(
                    "5 menit lalu"  to "Megawati Bernyanyi dan Berjoget saat Kampanye…",
                    "15 menit lalu" to "Gibran Harap Semua Pendukung di GBK Coblos No 2…"
                ),
                modifier = Modifier.height(150.dp).padding(vertical = 4.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Lihat laporan lainnya",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "5+",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Red)
                            .padding(horizontal = 16.dp)
                    )
                }

                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(Res.drawable.ic_share),
                        contentDescription = "Button Share",
                        modifier = Modifier.size(48.dp)
                    )
                }
            }

            LiveReportCard()
            LiveReportCard()
            LiveReportCard()
        }
    }
}