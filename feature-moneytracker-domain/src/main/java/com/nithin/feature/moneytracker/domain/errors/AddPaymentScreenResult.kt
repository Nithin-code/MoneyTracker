package com.nithin.feature.moneytracker.domain.errors

import com.nithin.core.common.exceptions.AppError

sealed class AddPaymentScreenResult(val title: String, val body: String) : AppError {
    data object InvalidNameError : AddPaymentScreenResult(title = "Invalid Name", body = "Please Enter Valid Name")
    data object InvalidAmountError : AddPaymentScreenResult(title = "Invalid Amount", body = "Please Enter Valid Amount")
    data object InvalidDateError : AddPaymentScreenResult(title = "Invalid Date", body = "Please Enter Valid Date")
    data class GenericError(val errorTitle: String,val errorBody: String) : AddPaymentScreenResult(title = errorTitle, body = errorBody)
    data object NoError : AddPaymentScreenResult("","")
}