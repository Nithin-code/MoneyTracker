package com.nithin.core.work.manager.di

import androidx.work.WorkManager
import com.nithin.core.common.workmanager.DeleteWorkerScheduler
import com.nithin.core.common.workmanager.SyncScheduler
import com.nithin.core.work.manager.delete_payment_worker.DeletePaymentWorkScheduler
import com.nithin.core.work.manager.delete_payment_worker.DeletePaymentWorker
import com.nithin.core.work.manager.syncScheduler.SyncSchedulerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val workManagerModule = module {
    single {
        WorkManager.getInstance(androidContext())
    }
    single<SyncScheduler> {
        SyncSchedulerImpl(get())
    }
    single<DeleteWorkerScheduler> {
        DeletePaymentWorkScheduler(get())
    }
}