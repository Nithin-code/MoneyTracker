package com.nithin.core.common.data

enum class PaymentStatus(val status: String) {
    SENT("Sent"),
    RECEIVED("Received");
    companion object{
        fun getPaymentStatusFromValue(value: String) : PaymentStatus {
            return when {
                value.trim().equals(PaymentStatus.SENT.status, ignoreCase = true) -> PaymentStatus.SENT
                else -> PaymentStatus.RECEIVED
            }
        }
    }
}

