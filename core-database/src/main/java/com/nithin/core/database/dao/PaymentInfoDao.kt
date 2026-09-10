package com.nithin.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nithin.core.common.data.SyncStatus
import com.nithin.core.database.model.PaymentInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface PaymentInfoDao {
    @Query("select * from payments where isDeleted=:isDeleted")
    fun getAllPaymentDetails(isDeleted: Boolean = false) : Flow<List<PaymentInfoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPayment(paymentInfoEntity: PaymentInfoEntity)

    @Query("Select * From payments where syncStatus=:syncStatus")
    suspend fun getAllPendingDetailsList(syncStatus: Int): List<PaymentInfoEntity>

    @Query("update payments set syncStatus=1 where serialNo =:id")
    suspend fun updateSyncStatusToSynced(id: String)

    @Delete
    suspend fun deletePaymentInfo(paymentInfoEntity: PaymentInfoEntity)

    @Query("update payments set isDeleted=:isDeleted where serialNo=:id")
    suspend fun updateDeleteStatus(id: String,isDeleted: Boolean)

    @Query("select * from payments where isDeleted=:isDeleted")
    suspend fun getAllPendingDeletes(isDeleted: Boolean = true) : List<PaymentInfoEntity>
}