package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.core.common.result.AppResult
import com.nithin.feature.moneytracker.domain.errors.AddPaymentScreenResult
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class AddPaymentDetailsUseCaseTest {

    @Test
    fun `addPaymentDetails should return invalid amount error when amount is zero`() = runTest{
        val fakeMoneyTrackerRepository = FakeMoneyTrackerRepository()
        val invalidPaymentInfo = FakePaymentInfo.fakePaymentInfo.copy(amount = 0.00)
        val fakeScheduler = FakeScheduler()
        val addPaymentDetailsUseCase = AddPaymentDetailsUseCase(repository = fakeMoneyTrackerRepository, syncScheduler = fakeScheduler)
        val actualResult = addPaymentDetailsUseCase.addPaymentDetails(paymentInfo = invalidPaymentInfo)
        val expectedResult = AppResult.Error(AddPaymentScreenResult.InvalidAmountError)
        assertEquals(
            expectedResult,
            actualResult
        )
    }

    @Test
    fun `addPaymentDetails should return invalid Name error when Name is Empty`() = runTest{
        val fakeMoneyTrackerRepository = FakeMoneyTrackerRepository()
        val invalidPaymentInfo = FakePaymentInfo.fakePaymentInfo.copy(name = "")
        val fakeScheduler = FakeScheduler()
        val addPaymentDetailsUseCase = AddPaymentDetailsUseCase(repository = fakeMoneyTrackerRepository, syncScheduler = fakeScheduler)
        val actualResult = addPaymentDetailsUseCase.addPaymentDetails(paymentInfo = invalidPaymentInfo)
        val expectedResult = AppResult.Error(AddPaymentScreenResult.InvalidNameError)
        assertEquals(
            expectedResult,
            actualResult
        )
    }

    @Test
    fun `addPaymentDetails should return invalid Date error when Day is Empty`() = runTest{
        val fakeMoneyTrackerRepository = FakeMoneyTrackerRepository()
        val invalidPaymentInfo = FakePaymentInfo.fakePaymentInfo.copy(day = "")
        val fakeScheduler = FakeScheduler()
        val addPaymentDetailsUseCase = AddPaymentDetailsUseCase(repository = fakeMoneyTrackerRepository, syncScheduler = fakeScheduler)
        val actualResult = addPaymentDetailsUseCase.addPaymentDetails(paymentInfo = invalidPaymentInfo)
        val expectedResult = AppResult.Error(AddPaymentScreenResult.InvalidDateError)
        assertEquals(
            expectedResult,
            actualResult
        )
    }

    @Test
    fun `addPaymentDetails should return Success when Given Data is Valid`() = runTest{
        val fakeMoneyTrackerRepository = FakeMoneyTrackerRepository()
        val invalidPaymentInfo = FakePaymentInfo.fakePaymentInfo
        val fakeScheduler = FakeScheduler()
        val addPaymentDetailsUseCase = AddPaymentDetailsUseCase(repository = fakeMoneyTrackerRepository, syncScheduler = fakeScheduler)
        val actualResult = addPaymentDetailsUseCase.addPaymentDetails(paymentInfo = invalidPaymentInfo)
        val expectedResult = AppResult.Success(Unit)
        assertEquals(
            expectedResult,
            actualResult
        )
    }



}