package com.nithin.feature.moneytracker.presentation.view_model.payments_list

sealed interface PaymentListEvents {
    data class OnDeletePayment(val id: String, val isDeleted: Boolean) : PaymentListEvents

    data class OnConfirmDelete(val id: String, val isDelete: Boolean) : PaymentListEvents
}