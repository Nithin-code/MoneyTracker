package com.nithin.moneytracker

import android.app.Application
import androidx.work.Configuration
import com.nithin.core.common.workmanager.DeleteWorker
import com.nithin.core.common.workmanager.SyncManager
import com.nithin.core.database.di.databaseModule
import com.nithin.core.firebase.di.firebaseModule
import com.nithin.core.work.manager.di.workManagerModule
import com.nithin.core.work.manager.factory.MoneyTrackerWorkerFactory
import com.nithin.feature.moneytracker.data.di.moneyTrackerDataModule
import com.nithin.feature.moneytracker.domain.di.moneyTrackerDomainModule
import com.nithin.feature.moneytracker.presentation.di.paymentsPresentationModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MoneyTrackerApplication : Application(), Configuration.Provider  {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MoneyTrackerApplication)
            modules(
                paymentsPresentationModule,
                moneyTrackerDataModule,
                moneyTrackerDomainModule,
                databaseModule,
                firebaseModule,
                workManagerModule,
            )
        }
    }

    override val workManagerConfiguration: Configuration
        get()  {
            val syncManager = getKoin().get<SyncManager>()
            val deleteWorker = getKoin().get<DeleteWorker>()
            return Configuration.Builder()
                .setWorkerFactory(
                    MoneyTrackerWorkerFactory(
                        syncManager = syncManager,
                        deleteWorker = deleteWorker
                    )
                ).build()
        }

}