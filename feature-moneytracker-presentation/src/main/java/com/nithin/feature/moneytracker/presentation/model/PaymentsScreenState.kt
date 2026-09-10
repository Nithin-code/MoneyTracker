package com.nithin.feature.moneytracker.presentation.model

import com.nithin.feature.moneytracker.domain.model.PaymentInfo

data class PaymentsScreenState(
    val isLoading : Boolean = false,
    val paymentRecords : List<PaymentInfo> = emptyList(),
    val errorMessage: String? = null,
    val showDeleteDialog: Boolean = false,
    val delectPaymentId: String? = null
)
