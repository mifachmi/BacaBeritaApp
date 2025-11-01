package id.mifachmi.bacaberitaapp.data.local

import app.cash.sqldelight.db.SqlDriver

// You can name this whatever you prefer, e.g., PlatformContext
public expect class PlatformContext

expect class DatabaseDriverFactory(context: PlatformContext) {
    fun createDriver(): SqlDriver
}