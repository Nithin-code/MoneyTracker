package com.nithin.feature.moneytracker.data.repository

import android.database.SQLException
import com.nithin.core.common.exceptions.DatabaseError
import com.nithin.core.common.result.AppResult
import com.nithin.core.database.provider.LocalDataSource
import com.nithin.feature.moneytracker.data.model.toPaymentEntity
import com.nithin.feature.moneytracker.data.model.toPaymentInfo
import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import com.nithin.feature.moneytracker.domain.repository.MoneyTrackerRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class MoneyTrackerRepositoryImpl(
    private val localDataSource: LocalDataSource
) : MoneyTrackerRepository {

    override suspend fun addPaymentDetails(paymentInfo: PaymentInfo): AppResult<Unit> {
        try {
            localDataSource.insertPaymentInfo(
                paymentInfoEntity = paymentInfo.toPaymentEntity()
            )
            return AppResult.Success(Unit)
        }catch (cancellationException: CancellationException){
            throw cancellationException
        }catch (exception: SQLException){
            return AppResult.Error(error = DatabaseError.SqlError(exception.message.toString()))
        }catch (exception: Exception){
            return AppResult.Error(error = DatabaseError.UnKnownError)
        }
    }

    override fun getAllPaymentDetails(): Flow<List<PaymentInfo>> {
        return localDataSource
            .getAllPaymentDetails()
            .map { paymentInfoEntities ->
                paymentInfoEntities.map { paymentInfoEntity ->
                    paymentInfoEntity.toPaymentInfo()
                }
            }
    }

    override suspend fun deletePayment(paymentInfo: PaymentInfo): AppResult<Unit> {
        try {
            localDataSource.deletePaymentInfo(paymentInfo.toPaymentEntity().copy(isDeleted = true))
            return AppResult.Success(Unit)
        }catch (cancelled: CancellationException){
            cancelled.printStackTrace()
            throw cancelled
        }catch (exception: SQLException){
            return AppResult.Error(error = DatabaseError.SqlError(exception.message.toString()))
        }catch (exception: Exception){
            return AppResult.Error(error = DatabaseError.UnKnownError)
        }
    }

    override suspend fun updateDeleteStatus(
        id: String,
        isDeleted: Boolean
    ): AppResult<Unit> {
        try {
            localDataSource.updateDeleteStatus(id,isDeleted)
            return AppResult.Success(Unit)
        }catch (cancelled: CancellationException){
            cancelled.printStackTrace()
            throw cancelled
        }catch (exception: SQLException){
            return AppResult.Error(error = DatabaseError.SqlError(exception.message.toString()))
        }catch (exception: Exception){
            return AppResult.Error(error = DatabaseError.UnKnownError)
        }
    }
}