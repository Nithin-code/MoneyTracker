package com.nithin.core.common.result

import com.nithin.core.common.exceptions.AppError

sealed interface AppResult<out T> {
    data class Success<T>(val data: T) : AppResult<T>
    data class Error(val error : AppError): AppResult<Nothing>
}