package id.mifachmi.bacaberitaapp.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import id.mifachmi.bacaberitaapp.data.local.DatabaseDriverFactory
import id.mifachmi.bacaberitaapp.data.local.PlatformContext

@Composable
actual fun createDriverFactory(): DatabaseDriverFactory {
    val context = LocalContext.current
    return DatabaseDriverFactory(PlatformContext(context))
}