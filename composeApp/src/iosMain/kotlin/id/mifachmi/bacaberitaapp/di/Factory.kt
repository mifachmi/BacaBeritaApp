package id.mifachmi.bacaberitaapp.di

import androidx.compose.runtime.Composable
import id.mifachmi.bacaberitaapp.data.local.DatabaseDriverFactory
import id.mifachmi.bacaberitaapp.data.local.PlatformContext

// 3. ACTUAL implementation for iOS, calling the default constructor
@Composable
actual fun createDriverFactory(): DatabaseDriverFactory {
    return DatabaseDriverFactory(PlatformContext())
}