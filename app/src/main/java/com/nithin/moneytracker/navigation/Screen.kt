package com.nithin.moneytracker.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object PaymentsListScreen : Screen
    @Serializable
    data object AddPaymentScreen : Screen
}