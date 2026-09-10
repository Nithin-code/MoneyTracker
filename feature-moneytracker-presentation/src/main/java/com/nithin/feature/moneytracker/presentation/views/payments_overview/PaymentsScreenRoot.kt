package com.nithin.feature.moneytracker.presentation.views.payments_overview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nithin.core.common.ui.design_system.CustomDialog
import com.nithin.core.common.ui.dialogs.DialogType
import com.nithin.core.common.ui.error_screens.FullPageErrorScreen
import com.nithin.core.common.ui.loading_screens.FullPageLoadingScreen
import com.nithin.feature.moneytracker.presentation.view_model.payments_list.PaymentListEvents
import com.nithin.feature.moneytracker.presentation.view_model.payments_list.PaymentsListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PaymentScreenRoot(
    paymentsListViewModel: PaymentsListViewModel = koinViewModel<PaymentsListViewModel>(),
    onAddPaymentButtonClick: () -> Unit
) {
    val screenState by paymentsListViewModel.screenState.collectAsStateWithLifecycle()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        when {
            screenState.isLoading -> {
                FullPageLoadingScreen()
            }

            !screenState.errorMessage.isNullOrEmpty() -> {
                FullPageErrorScreen(
                    errorMessage = screenState.errorMessage ?: "Unknown error occurred!"
                )
            }

            else -> {
                PaymentsListScreen(
                    listOfPayments = screenState.paymentRecords,
                    onAddPaymentButtonClick = onAddPaymentButtonClick,
                    onDeleteIconClicked = {
                        paymentsListViewModel.onPaymentEvent(
                            paymentListEvents = PaymentListEvents.OnDeletePayment(
                                id = it,
                                isDeleted = true
                            )
                        )
                    }
                )
            }
        }
        if (screenState.showDeleteDialog){
            CustomDialog(
                id = screenState.delectPaymentId,
                dialogTitle = "Confirm Your Delete",
                dialogDescription = "Are you sure to delete this payment?",
                onConfirmButtonClicked = {
                    it?.let { id->
                        paymentsListViewModel.onPaymentEvent(PaymentListEvents.OnConfirmDelete(
                            id = id,
                            isDelete = true
                        ))
                    }
                },
                onDismissButtonClicked = {paymentsListViewModel.dismissDialog()},
                dialogType = DialogType.DeleteIcon
            )
        }
    }
}