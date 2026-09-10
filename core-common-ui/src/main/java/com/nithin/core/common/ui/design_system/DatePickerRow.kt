package com.nithin.core.common.ui.design_system

import android.app.DatePickerDialog
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.LiquidGlassColors
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Composable
fun DatePickerRow(
    modifier: Modifier = Modifier,
    onDateSelected:(String, String, String, String) -> Unit
){
    var showDatePicker by remember {
        mutableStateOf(false)
    }

    val datePickerState = rememberDatePickerState()

    val selectedDate = remember(datePickerState.selectedDateMillis) {
        datePickerState.selectedDateMillis?.let { millis->
            java.time.Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
        }
    }

    val formattedDate = remember(selectedDate) {
        selectedDate?.format(
            DateTimeFormatter.ofPattern(
                "EEEE, MMMM dd, yyyy",
                Locale.getDefault()
            )
        ) ?: "Select a Date"
    }

    Surface(
        modifier = modifier,
        color = Color.Transparent,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 1.dp,
            color = LiquidGlassColors.GlassWhite.copy(alpha = 0.12f)
        ),
        onClick = {
            showDatePicker = true
        }
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = formattedDate,
                color = LiquidGlassColors.GlassWhite
            )
            Icon(
                imageVector = AppIcons.calendarIcon,
                contentDescription = "calendar_icon",
                tint = LiquidGlassColors.GlassWhite
            )
        }
    }

    if (showDatePicker){
        Surface(
            border = BorderStroke(
                width = 1.dp,
                color = LiquidGlassColors.GlassWhite
            )
        ) {
            androidx.compose.material3.DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDatePicker = false
                            selectedDate?.let { date ->
                                onDateSelected(
                                    date.dayOfWeek.name,
                                    date.dayOfMonth.toString(),
                                    date.month.name,
                                    date.year.toString()
                                )
                            }
                        }
                    ) {
                        Text(text = "OK", color = LiquidGlassColors.GlassWhite)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDatePicker = false
                        }
                    ) {
                        Text(text = "Cancel", color = LiquidGlassColors.GlassWhite)
                    }
                },
                colors = DatePickerDefaults.colors(
                    containerColor = Color.Transparent,

                    titleContentColor =
                        LiquidGlassColors.TextSecondary,

                    headlineContentColor =
                        LiquidGlassColors.TextPrimary,

                    weekdayContentColor =
                        LiquidGlassColors.TextSecondary,

                    subheadContentColor =
                        LiquidGlassColors.TextSecondary,

                    navigationContentColor =
                        LiquidGlassColors.TextPrimary,

                    yearContentColor =
                        LiquidGlassColors.TextSecondary,

                    currentYearContentColor =
                        LiquidGlassColors.TextPrimary,

                    selectedYearContentColor =
                        LiquidGlassColors.TextPrimary,

                    selectedYearContainerColor =
                        LiquidGlassColors.Primary.copy(alpha = 0.25f),

                    dayContentColor =
                        LiquidGlassColors.TextPrimary,

                    disabledDayContentColor =
                        LiquidGlassColors.TextTertiary.copy(alpha = 0.4f),

                    selectedDayContentColor =
                        Color.White,

                    selectedDayContainerColor =
                        LiquidGlassColors.Primary,

                    todayContentColor =
                        LiquidGlassColors.Primary,

                    todayDateBorderColor =
                        LiquidGlassColors.Primary,

                    dividerColor =
                        Color.White.copy(alpha = 0.12f)
                )
            ){
                DatePicker(
                    state = datePickerState,
                    colors = DatePickerDefaults.colors(
                        containerColor = Color.Transparent,

                        titleContentColor =
                            LiquidGlassColors.TextSecondary,

                        headlineContentColor =
                            LiquidGlassColors.TextPrimary,

                        weekdayContentColor =
                            LiquidGlassColors.TextSecondary,

                        subheadContentColor =
                            LiquidGlassColors.TextSecondary,

                        navigationContentColor =
                            LiquidGlassColors.TextPrimary,

                        yearContentColor =
                            LiquidGlassColors.TextSecondary,

                        currentYearContentColor =
                            LiquidGlassColors.TextPrimary,

                        selectedYearContentColor =
                            LiquidGlassColors.TextPrimary,

                        selectedYearContainerColor =
                            LiquidGlassColors.Primary.copy(alpha = 0.25f),

                        dayContentColor =
                            LiquidGlassColors.TextPrimary,

                        disabledDayContentColor =
                            LiquidGlassColors.TextTertiary.copy(alpha = 0.4f),

                        selectedDayContentColor =
                            Color.White,

                        selectedDayContainerColor =
                            LiquidGlassColors.Primary,

                        todayContentColor =
                            LiquidGlassColors.Primary,

                        todayDateBorderColor =
                            LiquidGlassColors.Primary,

                        dividerColor =
                            Color.White.copy(alpha = 0.12f)
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DatePickerRowPrev(){
    DatePickerRow(
        onDateSelected = { dayInWeek,day,month,year ->

        }
    )
}