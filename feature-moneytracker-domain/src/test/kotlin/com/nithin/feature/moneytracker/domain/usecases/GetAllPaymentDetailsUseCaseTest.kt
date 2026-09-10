package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.data.SyncStatus
import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class GetAllPaymentDetailsUseCaseTest {
    @Test
    fun `GetAllPaymentDetails fun should return payments from repository`() = runTest{
        val payment1 = PaymentInfo(
            name = "Nithin",
            description = "Zomato order",
            day = "09",
            month = "",
            year = "",
            dayInWeek = "",
            amount = 100.00,
            paymentStatus = PaymentStatus.SENT,
            syncStatus = SyncStatus.PENDING
        )
        val payments = listOf(payment1)
        val fakeRepository = FakeMoneyTrackerRepository()
        fakeRepository.payments = payments
        val useCase = GetAllPaymentDetailsUseCase(repository = fakeRepository)
        val result = useCase.getAllPaymentDetails()
        assertEquals(
            payments,
            result.first()
        )
    }
}