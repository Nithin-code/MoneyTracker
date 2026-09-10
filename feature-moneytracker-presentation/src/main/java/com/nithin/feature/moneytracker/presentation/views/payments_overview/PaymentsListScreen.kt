package com.nithin.feature.moneytracker.presentation.views.payments_overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.design_system.liquid_glass.GlassIconButton
import com.nithin.core.common.ui.design_system.liquid_glass.GlossyCircularButton
import com.nithin.core.common.ui.design_system.liquid_glass.LiquidGlassBackground
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.LiquidGlassColors
import com.nithin.feature.moneytracker.domain.model.PaymentInfo
import com.nithin.feature.moneytracker.presentation.liquid_glass.PaymentCardContent
import com.nithin.feature.moneytracker.presentation.liquid_glass.PaymentDetailsGlassCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PaymentsListScreen(
    listOfPayments: List<PaymentInfo>,
    onAddPaymentButtonClick:() -> Unit,
    onDeleteIconClicked:(String)-> Unit
){
    Scaffold { paddingValues ->
        LiquidGlassBackground(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Payments",
                            style = MaterialTheme.typography.titleMedium,
                            color = LiquidGlassColors.TextPrimary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Manage And Track All Your Payments",
                            style = MaterialTheme.typography.bodyMedium,
                            color = LiquidGlassColors.TextPrimary
                        )
                    }
                    GlossyCircularButton(
                        icon = AppIcons.addIcon,
                        iconTint = LiquidGlassColors.TextPrimary,
                        onClick = { onAddPaymentButtonClick() }
                    )
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(
                        vertical = 8.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = listOfPayments,
                        key = { it.serialNo }
                    ) { paymentRecord ->
                        PaymentCardContent(
                            id = paymentRecord.serialNo,
                            toAccountName = paymentRecord.name,
                            descriptionText = paymentRecord.description ?: "",
                            dayInWeek = paymentRecord.dayInWeek,
                            day = paymentRecord.day,
                            month = paymentRecord.month,
                            year = paymentRecord.year,
                            paymentStatus = paymentRecord.paymentStatus,
                            syncStatus = paymentRecord.syncStatus,
                            amount = paymentRecord.amount,
                            onDeleteIconClicked = { id -> onDeleteIconClicked.invoke(id) },
                            onEditIconClicked = { id -> }
                        )
                    }
                }
            }
        }
    }

}