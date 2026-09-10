package com.nithin.feature.moneytracker.domain.repository

import com.nithin.core.common.result.AppResult
import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import kotlinx.coroutines.flow.Flow

interface MoneyTrackerRepository {
    suspend fun addPaymentDetails(paymentInfo: PaymentInfo) : AppResult<Unit>
    fun getAllPaymentDetails() : Flow<List<PaymentInfo>>
    suspend fun deletePayment(paymentInfo: PaymentInfo): AppResult<Unit>
    suspend fun updateDeleteStatus(id: String, isDeleted: Boolean) : AppResult<Unit>
}