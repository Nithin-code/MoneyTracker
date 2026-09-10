package com.nithin.feature.moneytracker.presentation.model.add_payment

import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.ui.dialogs.DialogType
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors

data class AddPaymentScreenState(
    val toAccountName: String = "",
    val amount: String = "0",
    val dayInWeek: String? = null,
    val day: String? = null,
    val month: String? = null,
    val year: String? = null,
    val paymentStatus: PaymentStatus = PaymentStatus.SENT,
    val description: String = "",
    val showAlertDialog: Boolean = false,
    val alertDialogTitle: String = "",
    val alertDialogText: String = "",
    val dialogType: DialogType = DialogType.WarningIcon(dialogIcon = AppIcons.warningIcon, color = LiquidGlassColors.Warning)
)