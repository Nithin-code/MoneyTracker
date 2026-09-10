package com.nithin.feature.moneytracker.presentation.di

import com.nithin.feature.moneytracker.presentation.view_model.payments_list.PaymentsListViewModel
import com.nithin.feature.moneytracker.presentation.view_model.add_payment.AddPaymentScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val paymentsPresentationModule = module {
    viewModel {
        PaymentsListViewModel(get(), get())
    }
    viewModel {
        AddPaymentScreenViewModel(get())
    }
}