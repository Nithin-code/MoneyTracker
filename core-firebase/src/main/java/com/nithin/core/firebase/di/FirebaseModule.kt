package com.nithin.core.firebase.di

import com.google.firebase.firestore.FirebaseFirestore
import com.nithin.core.firebase.datasource.PaymentRemoteDataSource
import com.nithin.core.firebase.datasource.PaymentRemoteDataSourceImpl
import org.koin.dsl.module

val firebaseModule = module {
    single<FirebaseFirestore> {
        FirebaseFirestore.getInstance()
    }
    factory<PaymentRemoteDataSource> {
        PaymentRemoteDataSourceImpl(get())
    }
}