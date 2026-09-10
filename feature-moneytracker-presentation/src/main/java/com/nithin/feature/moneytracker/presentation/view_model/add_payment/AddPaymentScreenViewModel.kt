package com.nithin.feature.moneytracker.presentation.view_model.add_payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.core.common.data.SyncStatus
import com.nithin.core.common.result.AppResult
import com.nithin.core.common.ui.dialogs.DialogType
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors
import com.nithin.feature.moneytracker.domain.errors.AddPaymentScreenResult
import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import com.nithin.feature.moneytracker.domain.usecases.AddPaymentDetailsUseCase
import com.nithin.feature.moneytracker.presentation.model.add_payment.AddPaymentScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddPaymentScreenViewModel(
    private val addPaymentDetailsUseCase: AddPaymentDetailsUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(AddPaymentScreenState())
    val screenState = _screenState.asStateFlow()

    fun onUserEvent(userEvent: UserEvent){
        when(userEvent){
            is UserEvent.OnAmountChange -> {
                _screenState.update {
                    it.copy(amount = userEvent.amount)
                }
            }
            is UserEvent.OnDateChanged -> {
                _screenState.update {
                    it.copy(
                        dayInWeek = userEvent.datInWeek,
                        day = userEvent.day,
                        month = userEvent.month,
                        year = userEvent.year
                    )
                }
            }
            is UserEvent.OnNameChange -> {
                _screenState.update {
                    it.copy(toAccountName = userEvent.name)
                }
            }
            is UserEvent.OnPaymentStatusChanged -> {
                _screenState.update {
                    it.copy(
                        paymentStatus = userEvent.status
                    )
                }
            }

            is UserEvent.OnDescriptionChanged -> {
                _screenState.update {
                    it.copy(
                        description = userEvent.description
                    )
                }
            }
            UserEvent.OnSavePaymentClicked -> {
                onSavePaymentButtonClick()
            }

            UserEvent.OnAlertDialogDismissClicked -> {
                _screenState.update {
                    it.copy(showAlertDialog = false)
                }
            }
            UserEvent.OnAlertDialogOkClicked -> {
                _screenState.update {
                    it.copy(showAlertDialog = false)
                }
            }
        }
    }

    private fun onSavePaymentButtonClick(){
        viewModelScope.launch {
            val currentPaymentInfo = _screenState.value
            val paymentInfo = PaymentInfo(
                name = currentPaymentInfo.toAccountName.trim(),
                description = currentPaymentInfo.description.trim(),
                day = currentPaymentInfo.day ?: "",
                month = currentPaymentInfo.month ?: "",
                year = currentPaymentInfo.year ?: "",
                dayInWeek = currentPaymentInfo.dayInWeek ?: "",
                amount = currentPaymentInfo.amount.toDoubleOrNull() ?: 0.00,
                paymentStatus = currentPaymentInfo.paymentStatus,
                syncStatus = SyncStatus.PENDING
            )
            when(val result = addPaymentDetailsUseCase.addPaymentDetails(paymentInfo)){
                is AppResult.Error -> {
                    when(result.error){
                        is AddPaymentScreenResult.InvalidNameError->{
                            _screenState.update {
                                it.copy(
                                    showAlertDialog = true,
                                    alertDialogText = (result.error as AddPaymentScreenResult.InvalidNameError).body,
                                    alertDialogTitle = (result.error as AddPaymentScreenResult.InvalidNameError).title,
                                    dialogType = DialogType.WarningIcon(dialogIcon = AppIcons.warningIcon, color = LiquidGlassColors.Warning)
                                )
                            }
                        }
                        is AddPaymentScreenResult.InvalidDateError->{
                            _screenState.update {
                                it.copy(
                                    showAlertDialog = true,
                                    alertDialogText = (result.error as AddPaymentScreenResult.InvalidDateError).body,
                                    alertDialogTitle = (result.error as AddPaymentScreenResult.InvalidDateError).title,
                                    dialogType = DialogType.WarningIcon(dialogIcon = AppIcons.warningIcon, color = LiquidGlassColors.Warning)
                                )
                            }
                        }
                        is AddPaymentScreenResult.InvalidAmountError -> {
                            _screenState.update {
                                it.copy(
                                    showAlertDialog = true,
                                    alertDialogText = (result.error as AddPaymentScreenResult.InvalidAmountError).body,
                                    alertDialogTitle = (result.error as AddPaymentScreenResult.InvalidAmountError).title,
                                    dialogType = DialogType.WarningIcon(dialogIcon = AppIcons.warningIcon, color = LiquidGlassColors.Warning)
                                )
                            }
                        }
                    }
                }
                is AppResult.Success<*> -> {
                    _screenState.update {
                        it.copy(
                            showAlertDialog = true,
                            alertDialogTitle = "Added Successfully",
                            alertDialogText = "Successfully Added your Transaction",
                            dialogType = DialogType.WarningIcon(dialogIcon = AppIcons.successIcon, color = LiquidGlassColors.Success)
                        )
                    }
                }
            }

        }
    }

}