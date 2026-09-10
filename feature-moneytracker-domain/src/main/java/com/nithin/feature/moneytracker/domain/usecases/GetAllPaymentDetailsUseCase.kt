package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.feature.moneytracker.domain.repository.MoneyTrackerRepository

class GetAllPaymentDetailsUseCase(
    private val repository: MoneyTrackerRepository
) {
    fun getAllPaymentDetails() = repository.getAllPaymentDetails()
}