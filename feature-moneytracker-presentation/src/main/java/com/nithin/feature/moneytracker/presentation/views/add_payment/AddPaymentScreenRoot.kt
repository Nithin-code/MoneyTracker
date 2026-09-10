package com.nithin.feature.moneytracker.presentation.views.add_payment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.FontSize
import com.nithin.feature.moneytracker.presentation.view_model.add_payment.AddPaymentScreenViewModel
import org.koin.androidx.compose.koinViewModel

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AddPaymentScreenRoot(
//    onNavigateBack:()-> Unit
//){
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                modifier = Modifier.padding(horizontal = 8.dp),
//                title = {
//                    Text(
//                        modifier = Modifier
//                            .fillMaxWidth(1f),
//                        text = "Add Payment",
//                        textAlign = TextAlign.Center,
//                        fontSize = FontSize.screenFontSize
//                    )
//                },
//                navigationIcon = {
//                    Icon(
//                        modifier = Modifier.clickable{
//                            onNavigateBack()
//                        },
//                        imageVector = AppIcons.backIcon,
//                        contentDescription = "back_icon"
//                    )
//                },
//
//                )
//        }
//    ) { paddingValues ->
//        AddPaymentScreen(
//            modifier = Modifier.fillMaxSize().padding(paddingValues)
//        )
//    }
//
//
//}