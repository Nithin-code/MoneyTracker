package com.nithin.core.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // add new column with default value
        db.execSQL("ALTER TABLE payments ADD COLUMN isDeleted INTEGER NOT NULL DEFAULT 0")
    }
}

