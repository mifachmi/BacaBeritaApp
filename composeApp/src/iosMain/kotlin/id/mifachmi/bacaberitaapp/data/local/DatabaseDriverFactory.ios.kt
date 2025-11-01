package id.mifachmi.bacaberitaapp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import id.mifachmi.bacaberitaapp.database.AppDatabase

actual class PlatformContext

actual class DatabaseDriverFactory actual constructor(
    private val context: PlatformContext
) {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "app.db")
    }
}