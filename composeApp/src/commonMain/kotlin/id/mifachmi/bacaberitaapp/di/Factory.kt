package id.mifachmi.bacaberitaapp.di

import androidx.compose.runtime.Composable
import id.mifachmi.bacaberitaapp.data.local.DatabaseDriverFactory

// 1. EXPECT a Composable function that will provide the factory
@Composable
expect fun createDriverFactory(): DatabaseDriverFactory