package com.nithin.feature.moneytracker.data.sync_manager

import com.nithin.core.common.workmanager.SyncManager
import com.nithin.core.database.provider.LocalDataSource
import com.nithin.core.firebase.datasource.PaymentRemoteDataSource
import com.nithin.feature.moneytracker.data.model.toPaymentRemoteData

class SyncManagerImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: PaymentRemoteDataSource
): SyncManager {
    override suspend fun syncData() {
        val pendingItems = localDataSource.getAllPendingPaymentsList()
        pendingItems.forEach { pendingItem->
            remoteDataSource.upsert(paymentRemoteModel = pendingItem.toPaymentRemoteData())
            localDataSource.updateSyncStatusToSynced(pendingItem.serialNo)
        }
    }
}