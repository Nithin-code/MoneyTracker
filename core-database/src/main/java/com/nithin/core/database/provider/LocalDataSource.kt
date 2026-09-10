package com.nithin.core.database.provider

import com.nithin.core.common.data.SyncStatus
import com.nithin.core.database.dao.PaymentInfoDao
import com.nithin.core.database.model.PaymentInfoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.withContext

class LocalDataSource internal constructor(
    private val paymentInfoDao: PaymentInfoDao
){
    suspend fun insertPaymentInfo(paymentInfoEntity: PaymentInfoEntity){
        withContext(Dispatchers.IO){
            try {
                paymentInfoDao.insertPayment(paymentInfoEntity)
            }catch (t : Throwable) {
                throw t
            }
        }
    }
    fun getAllPaymentDetails() = paymentInfoDao.getAllPaymentDetails()
    suspend fun getAllPendingPaymentsList() = paymentInfoDao.getAllPendingDetailsList(SyncStatus.PENDING.status)
    suspend fun updateSyncStatusToSynced(id: String) = paymentInfoDao.updateSyncStatusToSynced(id)
    suspend fun deletePaymentInfo(paymentInfoEntity: PaymentInfoEntity){
        withContext(Dispatchers.IO){
            try {
                paymentInfoDao.deletePaymentInfo(paymentInfoEntity)
            }catch (t: Exception){
                throw t
            }
        }
    }
    suspend fun updateDeleteStatus(id: String, isDeleted: Boolean){
        withContext(Dispatchers.IO){
            try {
                paymentInfoDao.updateDeleteStatus(id,isDeleted)
            }catch (t: Exception){
                throw t
            }
        }
    }

    suspend fun getAllPendingDeletes() = paymentInfoDao.getAllPendingDeletes()
}