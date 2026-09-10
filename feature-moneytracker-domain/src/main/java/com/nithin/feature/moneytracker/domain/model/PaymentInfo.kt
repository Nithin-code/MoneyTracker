package com.nithin.feature.moneytracker.domain.model

import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.data.SyncStatus
import java.util.UUID

data class PaymentInfo(
    val serialNo: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String?,
    val day: String,
    val month: String,
    val year: String,
    val dayInWeek: String,
    val amount: Double,
    val paymentStatus : PaymentStatus,
    val syncStatus: SyncStatus
)
