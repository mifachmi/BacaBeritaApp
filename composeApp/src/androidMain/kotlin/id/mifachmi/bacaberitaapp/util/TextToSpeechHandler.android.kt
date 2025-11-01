package id.mifachmi.bacaberitaapp.util

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

@Composable
actual fun rememberTextToSpeech(): ITextToSpeech {
    val context = LocalContext.current
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    var engine: TextToSpeech? = null

    DisposableEffect(Unit) {
        engine = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                engine?.language = Locale.forLanguageTag("id-ID")
            }
        }
        tts = engine

        onDispose {
            engine.stop()
            engine.shutdown()
        }
    }

    return remember {
        object : ITextToSpeech {
            override fun speak(text: String) {
                tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts_utterance")
            }

            override fun stop() {
                tts?.stop()
            }
        }
    }
}