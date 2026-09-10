package com.nithin.feature.moneytracker.presentation.views.add_payment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun PaymentStatusRadioButtonsScreen(
    onPaymentStatusChanged:(PaymentStatus) -> Unit
){
    var selectedPosition by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        PaymentStatus.entries.forEachIndexed { index, status ->
            RadioButtonWithText(
                text = status.status,
                index = index,
                selectedPos = selectedPosition,
                onRadioButtonSelected = {
                    selectedPosition = it
                    onPaymentStatusChanged.invoke(
                        PaymentStatus.entries[it]
                    )
                }
            )
        }
    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    index: Int,
    selectedPos: Int,
    onRadioButtonSelected: (Int)-> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onRadioButtonSelected.invoke(index)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = LiquidGlassColors.GlassWhite
        )
        RadioButton(
            selected = (selectedPos == index),
            onClick = { onRadioButtonSelected.invoke(index) },
            colors = RadioButtonDefaults.colors(
                selectedColor = LiquidGlassColors.PrimaryLight,
                unselectedColor = LiquidGlassColors.GlassWhite
            )
        )
    }
}

@Preview
@Composable
fun Prev1(){
    RadioButtonWithText(
        text = "Sent",
        index = 1,
        selectedPos = 0,
        onRadioButtonSelected = {}
    )
}