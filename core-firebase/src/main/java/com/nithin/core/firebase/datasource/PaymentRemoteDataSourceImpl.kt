package com.nithin.core.firebase.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.nithin.core.firebase.model.PaymentRemoteModel
import kotlinx.coroutines.tasks.await

class PaymentRemoteDataSourceImpl(
    private val firebaseDataBase: FirebaseFirestore
): PaymentRemoteDataSource {
    val collection = firebaseDataBase.collection("payments")
    override suspend fun upsert(paymentRemoteModel: PaymentRemoteModel) {
        collection
            .document(paymentRemoteModel.serialNo)
            .set(paymentRemoteModel)
            .await()
    }

    override suspend fun delete(paymentRemoteModel: PaymentRemoteModel) {
        collection
            .document(paymentRemoteModel.serialNo)
            .delete()
            .await()
    }
}