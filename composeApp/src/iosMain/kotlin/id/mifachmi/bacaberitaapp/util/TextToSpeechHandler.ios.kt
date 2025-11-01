package id.mifachmi.bacaberitaapp.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import platform.AVFAudio.AVSpeechBoundary
import platform.AVFAudio.AVSpeechSynthesisVoice
import platform.AVFAudio.AVSpeechSynthesizer
import platform.AVFAudio.AVSpeechUtterance

@Composable
actual fun rememberTextToSpeech(): ITextToSpeech{
    val synthesizer = remember { AVSpeechSynthesizer() }

    DisposableEffect(Unit) {
        onDispose {
            synthesizer.stopSpeakingAtBoundary(AVSpeechBoundary.AVSpeechBoundaryImmediate) // 0 = immediate
        }
    }

    return remember {
        object : ITextToSpeech {
            override fun speak(text: String) {
                val utterance = AVSpeechUtterance.speechUtteranceWithString(text)
                utterance.voice = AVSpeechSynthesisVoice.voiceWithLanguage("id-ID")
                synthesizer.speakUtterance(utterance)
            }

            override fun stop() {
                synthesizer.stopSpeakingAtBoundary(AVSpeechBoundary.AVSpeechBoundaryImmediate)
            }
        }
    }
}