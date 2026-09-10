package com.nithin.feature.moneytracker.data.di

import com.nithin.core.common.workmanager.DeleteWorker
import com.nithin.core.common.workmanager.SyncManager
import com.nithin.feature.moneytracker.data.repository.MoneyTrackerRepositoryImpl
import com.nithin.feature.moneytracker.data.sync_manager.DeleteWorkerImpl
import com.nithin.feature.moneytracker.data.sync_manager.SyncManagerImpl
import com.nithin.feature.moneytracker.domain.repository.MoneyTrackerRepository
import org.koin.dsl.module

val moneyTrackerDataModule = module {
    single<MoneyTrackerRepository> {
        MoneyTrackerRepositoryImpl(
            get()
        )
    }
    single<SyncManager> {
        SyncManagerImpl(
            get(),
            get()
        )
    }
    single<DeleteWorker> {
        DeleteWorkerImpl(
            get(),
            get()
        )
    }
}