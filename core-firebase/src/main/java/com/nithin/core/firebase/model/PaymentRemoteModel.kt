package com.nithin.core.firebase.model

data class PaymentRemoteModel(
    val serialNo: String,
    val name: String,
    val description: String?,
    val day: String,
    val month: String,
    val year: String,
    val dayInWeek: String,
    val amount: Double,
    val paymentStatus : String,
)
