package com.nithin.moneytracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nithin.feature.moneytracker.presentation.views.add_payment.AddPaymentScreenLiquidGlassRoot
import com.nithin.feature.moneytracker.presentation.views.payments_overview.PaymentScreenRoot

@Composable
fun AppNavigationGraph(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.PaymentsListScreen
    ){
        composable<Screen.PaymentsListScreen> {
            PaymentScreenRoot(
                onAddPaymentButtonClick = {
                    navController.navigate(Screen.AddPaymentScreen)
                }
            )
        }
        composable<Screen.AddPaymentScreen> {
            AddPaymentScreenLiquidGlassRoot(
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}