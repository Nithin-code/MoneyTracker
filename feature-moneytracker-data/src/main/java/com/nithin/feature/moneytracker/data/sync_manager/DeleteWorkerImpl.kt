package com.nithin.feature.moneytracker.data.sync_manager

import com.nithin.core.common.workmanager.DeleteWorker
import com.nithin.core.database.provider.LocalDataSource
import com.nithin.core.firebase.datasource.PaymentRemoteDataSource
import com.nithin.feature.moneytracker.data.model.toPaymentRemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.withContext

class DeleteWorkerImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: PaymentRemoteDataSource
) : DeleteWorker {
    override suspend fun deleteWork() {
        val pendingDeletes = localDataSource.getAllPendingDeletes()
        pendingDeletes.forEach { pendingDelete->
            remoteDataSource.delete(pendingDelete.toPaymentRemoteData())
            withContext(NonCancellable){
                localDataSource.deletePaymentInfo(pendingDelete)
            }
        }
    }
}