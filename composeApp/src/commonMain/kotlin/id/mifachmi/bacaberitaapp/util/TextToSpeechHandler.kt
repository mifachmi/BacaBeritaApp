package id.mifachmi.bacaberitaapp.util

import androidx.compose.runtime.Composable

interface ITextToSpeech {
    fun speak(text: String)
    fun stop()
}

@Composable
expect fun rememberTextToSpeech(): ITextToSpeech