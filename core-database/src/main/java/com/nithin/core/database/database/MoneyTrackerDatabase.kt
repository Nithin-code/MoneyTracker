package com.nithin.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nithin.core.database.dao.PaymentInfoDao
import com.nithin.core.database.model.PaymentInfoEntity

@Database(
    entities = [PaymentInfoEntity::class],
    version = 2,
    exportSchema = false
)
internal abstract class MoneyTrackerDatabase : RoomDatabase() {
    abstract fun paymentInfoDao() : PaymentInfoDao
}