package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import com.nithin.feature.moneytracker.domain.repository.MoneyTrackerRepository

class DeletePaymentUseCase(
    private val moneyTrackerRepository: MoneyTrackerRepository
) {
    suspend fun deletePaymentInfo(paymentInfo: PaymentInfo){
        moneyTrackerRepository.deletePayment(paymentInfo)
    }
}