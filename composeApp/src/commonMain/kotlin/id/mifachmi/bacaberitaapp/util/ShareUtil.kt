package id.mifachmi.bacaberitaapp.util

import androidx.compose.runtime.Composable

interface ShareHandler {
    fun shareText(text: String, chooserTitle: String? = null)
}

@Composable
expect fun rememberShareHandler(): ShareHandler