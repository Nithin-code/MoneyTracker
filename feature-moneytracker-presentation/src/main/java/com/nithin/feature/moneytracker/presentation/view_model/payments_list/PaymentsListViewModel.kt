package com.nithin.feature.moneytracker.presentation.view_model.payments_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.core.common.result.AppResult
import com.nithin.feature.moneytracker.domain.usecases.GetAllPaymentDetailsUseCase
import com.nithin.feature.moneytracker.domain.usecases.UpdateDeleteStatusUseCase
import com.nithin.feature.moneytracker.presentation.model.PaymentsScreenState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PaymentsListViewModel(
    private val getAllPaymentDetailsUseCase: GetAllPaymentDetailsUseCase,
    private val updateDeleteStatusUseCase: UpdateDeleteStatusUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(PaymentsScreenState())
    val screenState = _screenState.asStateFlow()


    init {
        getAllPaymentRecords()
    }

    private fun getAllPaymentRecords(){
        viewModelScope.launch {
            getAllPaymentDetailsUseCase
                .getAllPaymentDetails()
                .onStart {
                    _screenState.update {
                        it.copy(isLoading = true)
                    }
                }.catch { throwable->
                    _screenState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "UnExpected Error"
                        )
                    }
                }.collectLatest { listOfPaymentInfo->
                    _screenState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = null,
                            paymentRecords = listOfPaymentInfo
                        )
                    }
                }
        }
    }

    fun onPaymentEvent(
        paymentListEvents: PaymentListEvents
    ){
        when(paymentListEvents){
            is PaymentListEvents.OnDeletePayment -> {
                _screenState.update {
                    it.copy(showDeleteDialog = true, delectPaymentId = paymentListEvents.id)
                }
            }

            is PaymentListEvents.OnConfirmDelete -> {
                viewModelScope.launch {
                    val result = updateDeleteStatusUseCase.updateDeleteStatus(
                        paymentListEvents.id,
                        paymentListEvents.isDelete
                    )
                    when(result){
                        is AppResult.Error -> {
                            println("Error Occurred...")
                        }
                        is AppResult.Success<*> -> {
                            dismissDialog()
                        }
                    }
                }
            }
        }
    }


    fun dismissDialog(){
        _screenState.update {
            it.copy(showDeleteDialog = false)
        }
    }


}