package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.data.SyncStatus
import com.nithin.feature.moneytracker.domain.model.PaymentInfo

object FakePaymentInfo{
    val fakePaymentInfo = PaymentInfo(
        name = "Nithin",
        description = "Zomato order",
        day = "09",
        month = "Mon",
        year = "YYYY",
        dayInWeek = "Tue",
        amount = 100.00,
        paymentStatus = PaymentStatus.SENT,
        syncStatus = SyncStatus.PENDING
    )
}
