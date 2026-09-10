package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.core.common.result.AppResult
import com.nithin.core.common.workmanager.SyncScheduler
import com.nithin.feature.moneytracker.domain.errors.AddPaymentScreenResult
import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import com.nithin.feature.moneytracker.domain.repository.MoneyTrackerRepository

class AddPaymentDetailsUseCase(
    private val repository: MoneyTrackerRepository,
    private val syncScheduler: SyncScheduler
) {
    suspend fun addPaymentDetails(paymentInfo: PaymentInfo) : AppResult<Unit> {
        when(validatePaymentDetails(paymentInfo)){
            is AddPaymentScreenResult.GenericError -> {
                return AppResult.Error(AddPaymentScreenResult.GenericError("",""))
            }
            AddPaymentScreenResult.InvalidAmountError -> {
                return AppResult.Error(AddPaymentScreenResult.InvalidAmountError)
            }
            AddPaymentScreenResult.InvalidDateError -> {
                return AppResult.Error(AddPaymentScreenResult.InvalidDateError)
            }
            AddPaymentScreenResult.InvalidNameError -> {
                return AppResult.Error(AddPaymentScreenResult.InvalidNameError)
            }
            AddPaymentScreenResult.NoError -> {
                val result =  repository.addPaymentDetails(paymentInfo)
                if (result is AppResult.Success){
                    syncScheduler.scheduleSync()
                }
                return result
            }
        }
    }
    private  fun validatePaymentDetails(paymentInfo: PaymentInfo) : AddPaymentScreenResult {
        when {
            paymentInfo.name.isEmpty() -> {
                return AddPaymentScreenResult.InvalidNameError
            }

            paymentInfo.amount <= 0.00 -> {
                return AddPaymentScreenResult.InvalidAmountError
            }

            paymentInfo.day.isEmpty() ||
                    paymentInfo.dayInWeek.isEmpty() ||
                    paymentInfo.month.isEmpty() ||
                    paymentInfo.year.isEmpty() -> {
                return AddPaymentScreenResult.InvalidDateError
            }
            else -> {
                return AddPaymentScreenResult.NoError
            }
        }

    }
}