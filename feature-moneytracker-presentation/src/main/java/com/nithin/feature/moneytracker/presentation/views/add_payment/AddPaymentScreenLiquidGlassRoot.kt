package com.nithin.feature.moneytracker.presentation.views.add_payment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nithin.core.common.ui.design_system.DatePickerRow
import com.nithin.core.common.ui.design_system.liquid_glass.LiquidGlassBackIcon
import com.nithin.core.common.ui.design_system.liquid_glass.LiquidGlassBackground
import com.nithin.core.common.ui.design_system.liquid_glass.OutLinedGlassTextField
import com.nithin.core.common.ui.icons.AppIconType
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.LiquidGlassColors
import com.nithin.feature.moneytracker.presentation.view_model.add_payment.AddPaymentScreenViewModel
import com.nithin.feature.moneytracker.presentation.view_model.add_payment.UserEvent
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun AddPaymentScreenLiquidGlassRoot(
    onNavigateBack:()-> Unit,
){

    Scaffold { paddingValues ->
        AddPaymentScreen(
            paddingValues = paddingValues,
            onNavigateBack = onNavigateBack
        )
    }
}

@Composable
fun HeaderSection(
    onBackClick:()-> Unit
){
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        LiquidGlassBackIcon(
            modifier = Modifier.align(Alignment.CenterStart),
            onClick = onBackClick
        )

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Add Payment",
            style = MaterialTheme.typography.titleLarge,
            color = LiquidGlassColors.GlassWhite,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddPaymentScreenLiquidGlassRootPrev(){
    AddPaymentScreenLiquidGlassRoot({})
}
