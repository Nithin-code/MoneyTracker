package com.nithin.feature.moneytracker.presentation.views.add_payment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nithin.core.common.ui.design_system.CustomDialog
import com.nithin.core.common.ui.design_system.DatePickerRow
import com.nithin.core.common.ui.design_system.EditTextName
import com.nithin.core.common.ui.design_system.liquid_glass.LiquidGlassBackground
import com.nithin.core.common.ui.design_system.liquid_glass.OutLinedGlassTextField
import com.nithin.core.common.ui.icons.AppIconType
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.FontSize
import com.nithin.core.common.ui.themes.LiquidGlassColors
import com.nithin.feature.moneytracker.presentation.view_model.add_payment.AddPaymentScreenViewModel
import com.nithin.feature.moneytracker.presentation.view_model.add_payment.UserEvent
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPaymentScreen(
    paddingValues: PaddingValues = PaddingValues(),
    viewModel: AddPaymentScreenViewModel= koinViewModel(),
    onNavigateBack:()-> Unit
){
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        if (screenState.showAlertDialog){
            CustomDialog(
                dialogTitle = screenState.alertDialogTitle,
                dialogDescription = screenState.alertDialogText,
                onDismissButtonClicked = {
                    viewModel.onUserEvent(
                        UserEvent.OnAlertDialogDismissClicked
                    )
                },
                onConfirmButtonClicked = {
                    viewModel.onUserEvent(
                        UserEvent.OnAlertDialogOkClicked
                    )
                },
                dialogType = screenState.dialogType
            )
        }

        LiquidGlassBackground(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp)
                    .imePadding()
                    .verticalScroll(state = rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HeaderSection(
                    onBackClick = onNavigateBack
                )

                OutLinedGlassTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = screenState.toAccountName,
                    onTextChanged = {
                        viewModel.onUserEvent(
                            UserEvent.OnNameChange(it)
                        )
                    },
                    icon = AppIconType.ImageVector(AppIcons.contactIcon),
                    hint = "Name",
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                )

                OutLinedGlassTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = screenState.amount,
                    onTextChanged = {
                        viewModel.onUserEvent(
                            userEvent = UserEvent.OnAmountChange(it)
                        )
                    },
                    icon = AppIconType.Drawable(AppIcons.moneyIcon),
                    hint = "Amount",
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                )

                DatePickerRow(
                    modifier = Modifier.fillMaxWidth(),
                    onDateSelected = { dayInWeek,day,month,year ->
                        viewModel.onUserEvent(
                            UserEvent.OnDateChanged(
                                dayInWeek,
                                day,
                                month,
                                year
                            )
                        )
                    }
                )

                PaymentStatusRadioButtonsScreen(
                    onPaymentStatusChanged = {
                        viewModel.onUserEvent(UserEvent.OnPaymentStatusChanged(it))
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    value = screenState.description,
                    onValueChange = {
                        viewModel.onUserEvent(
                            UserEvent.OnDescriptionChanged(it)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = LiquidGlassColors.TextPrimary,
                        unfocusedTextColor = LiquidGlassColors.TextSecondary,
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedBorderColor = LiquidGlassColors.GlassWhite,
                        unfocusedBorderColor = LiquidGlassColors.GlassWhite.copy(alpha = 0.12f),
                        focusedLeadingIconColor = LiquidGlassColors.GlassWhite,
                        unfocusedLeadingIconColor = LiquidGlassColors.GlassWhite,
                        focusedLabelColor = LiquidGlassColors.GlassWhite,
                        unfocusedLabelColor = LiquidGlassColors.GlassWhite
                    ),
                    label = {
                        Text(
                            text = "Description"
                        )
                    },
                    shape = RoundedCornerShape(20.dp)
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        viewModel.onUserEvent(
                            UserEvent.OnSavePaymentClicked
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LiquidGlassColors.PrimaryLight
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = LiquidGlassColors.GlassWhite
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "Save Payment",
                        color = LiquidGlassColors.GlassWhite
                    )
                }

            }
        }
    }
}
