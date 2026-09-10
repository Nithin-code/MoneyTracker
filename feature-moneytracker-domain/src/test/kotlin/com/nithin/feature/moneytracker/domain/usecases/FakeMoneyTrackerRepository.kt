package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.core.common.result.AppResult
import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import com.nithin.feature.moneytracker.domain.repository.MoneyTrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeMoneyTrackerRepository : MoneyTrackerRepository {
    var payments = emptyList<PaymentInfo>()

    var addPaymentResult = AppResult.Success(Unit)

    override suspend fun addPaymentDetails(paymentInfo: PaymentInfo): AppResult<Unit> {
        return addPaymentResult
    }

    override fun getAllPaymentDetails(): Flow<List<PaymentInfo>> {
        return flowOf(payments)
    }

    override suspend fun deletePayment(paymentInfo: PaymentInfo): AppResult<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updateDeleteStatus(
        id: String,
        isDeleted: Boolean
    ): AppResult<Unit> {
        TODO("Not yet implemented")
    }
}