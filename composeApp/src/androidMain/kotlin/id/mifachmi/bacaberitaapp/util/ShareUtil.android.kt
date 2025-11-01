package id.mifachmi.bacaberitaapp.util

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext


@Composable
actual fun rememberShareHandler(): ShareHandler {
    val context = LocalContext.current
    return remember(context) {
        object : ShareHandler {
            override fun shareText(text: String, chooserTitle: String?) {
                val sendIntent = Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_TEXT, text)
                    type = "text/plain"
                }
                val chooser = Intent.createChooser(sendIntent, chooserTitle ?: "Share")
                context.startActivity(chooser)
            }
        }
    }
}