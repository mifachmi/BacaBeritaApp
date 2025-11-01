package id.mifachmi.bacaberitaapp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import id.mifachmi.bacaberitaapp.database.AppDatabase

actual class PlatformContext(
    val context: Context
)

actual class DatabaseDriverFactory actual constructor(
    private val context: PlatformContext
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context.context, "app.db")
    }
}