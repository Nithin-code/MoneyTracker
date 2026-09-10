package com.nithin.core.firebase.datasource

import com.nithin.core.firebase.model.PaymentRemoteModel

interface PaymentRemoteDataSource {
    suspend fun upsert(paymentRemoteModel: PaymentRemoteModel)
    suspend fun delete(paymentRemoteModel: PaymentRemoteModel)
}