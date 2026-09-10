package com.nithin.core.database.di

import androidx.room.Room
import com.nithin.core.database.dao.PaymentInfoDao
import com.nithin.core.database.database.MoneyTrackerDatabase
import com.nithin.core.database.migrations.MIGRATION_1_2
import com.nithin.core.database.provider.LocalDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            MoneyTrackerDatabase::class.java,
            "money_tracker_db"
        ).addMigrations(MIGRATION_1_2).build()
    }
    single<PaymentInfoDao> {
        get<MoneyTrackerDatabase>().paymentInfoDao()
    }
    single<LocalDataSource> {
        LocalDataSource(get())
    }
}