package com.nithin.feature.moneytracker.presentation.view_model.add_payment

import com.nithin.core.common.data.PaymentStatus

sealed interface UserEvent {
    data class OnNameChange(val name: String) : UserEvent
    data class OnAmountChange(val amount: String) : UserEvent
    data class OnDateChanged(val datInWeek: String, val day: String, val month: String, val year: String) : UserEvent
    data class OnPaymentStatusChanged(val status: PaymentStatus) : UserEvent
    data class OnDescriptionChanged(val description: String): UserEvent

    data object OnSavePaymentClicked : UserEvent
    data object OnAlertDialogDismissClicked: UserEvent
    data object OnAlertDialogOkClicked: UserEvent
}