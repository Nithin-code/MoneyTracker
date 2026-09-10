package com.nithin.moneytracker

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.nithin.feature.moneytracker.presentation.views.add_payment.AddPaymentScreen
import com.nithin.feature.moneytracker.presentation.views.payments_overview.PaymentScreenRoot
import com.nithin.moneytracker.navigation.AppNavigationGraph
import com.nithin.moneytracker.ui.theme.MoneyTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoneyTrackerTheme {
                AppNavigationGraph()

            }
        }
    }
}
