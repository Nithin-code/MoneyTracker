package com.nithin.core.common.exceptions

sealed class DatabaseError(val errorMessage: String) : AppError{
    data class SqlError(val message: String) : DatabaseError(message)
    data object UnKnownError : DatabaseError("Unknown Error")
}