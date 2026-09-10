package com.nithin.feature.moneytracker.domain.di

import com.nithin.feature.moneytracker.domain.usecases.AddPaymentDetailsUseCase
import com.nithin.feature.moneytracker.domain.usecases.GetAllPaymentDetailsUseCase
import com.nithin.feature.moneytracker.domain.usecases.UpdateDeleteStatusUseCase
import org.koin.dsl.module


val moneyTrackerDomainModule = module {
    factory<AddPaymentDetailsUseCase> {
        AddPaymentDetailsUseCase(get(), get())
    }
    factory<GetAllPaymentDetailsUseCase> {
        GetAllPaymentDetailsUseCase(get())
    }
    factory<UpdateDeleteStatusUseCase> {
        UpdateDeleteStatusUseCase(get(), get())
    }
}