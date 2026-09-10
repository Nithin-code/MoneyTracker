package com.nithin.feature.moneytracker.presentation.liquid_glass

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.data.SyncStatus
import com.nithin.core.common.ui.design_system.StatusGlassChip
import com.nithin.core.common.ui.design_system.liquid_glass.GlassCard
import com.nithin.core.common.ui.design_system.liquid_glass.GlassIconButton
import com.nithin.core.common.ui.design_system.liquid_glass.GlassSyncStatus
import com.nithin.core.common.ui.design_system.liquid_glass.PaymentDetailsLiquidGlassCard
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors
import kotlin.text.isNotBlank


@Composable
fun PaymentCardContent(
    modifier: Modifier = Modifier,
    id: String,
    toAccountName: String,
    descriptionText: String,
    dayInWeek: String,
    day: String,
    month: String,
    year: String,
    paymentStatus: PaymentStatus,
    syncStatus: SyncStatus,
    amount: Double,
    onDeleteIconClicked: (String) -> Unit,
    onEditIconClicked: (String) -> Unit,
){

    val dateString = "$dayInWeek, $day, $month, $year"

    PaymentDetailsLiquidGlassCard {
        ConstraintLayout(
            modifier = modifier
                .fillMaxWidth()
        ) {
            val (
                icon,
                name,
                description,
                date,
                paymentStatusRef,
                syncStatusRef,
                amountRef,
                editButtonRef,
                deleteButtonRef
            ) = createRefs()
            //
            PaymentIcon(
                modifier = Modifier.constrainAs(icon){
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )
            Text(
                text = toAccountName,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleMedium,
                color = LiquidGlassColors.TextPrimary,
                modifier = Modifier.constrainAs(name){
                    start.linkTo(icon.end , margin = 12.dp)
                    top.linkTo(parent.top)
                    end.linkTo(amountRef.start, margin = 8.dp)
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                modifier = Modifier.constrainAs(description){
                    top.linkTo(name.bottom, margin = 4.dp)
                    start.linkTo(name.start)
                },
                text = descriptionText,
                style = MaterialTheme.typography.bodyMedium,
                color = LiquidGlassColors.TextSecondary,
            )
            Text(
                modifier= Modifier.constrainAs(date){
                    top.linkTo(description.bottom, margin = 4.dp)
                    start.linkTo(name.start)
                },
                text = dateString,
                style = MaterialTheme.typography.labelMedium,
                color = LiquidGlassColors.TextTertiary,
            )
            StatusGlassChip(
                modifier = Modifier.constrainAs(paymentStatusRef){
                    top.linkTo(date.bottom, margin = 6.dp)
                    start.linkTo(name.start)
                    bottom.linkTo(parent.bottom)
                },
                paymentStatus = paymentStatus
            )
            GlassSyncStatus(
                modifier = Modifier.constrainAs(syncStatusRef){
                    top.linkTo(date.bottom, margin = 6.dp)
                    bottom.linkTo(paymentStatusRef.bottom)
                    start.linkTo(paymentStatusRef.end, margin = 8.dp)
                },
                syncStatus = syncStatus
            )
            Text(
                modifier = Modifier.constrainAs(amountRef){
                    top.linkTo(name.top)
                    end.linkTo(editButtonRef.start, margin = 8.dp)
                },
                text = "$amount",
                style = MaterialTheme.typography.titleLarge,
                color = LiquidGlassColors.TextTertiary
            )
            GlassIconButton(
                modifier = Modifier.constrainAs(editButtonRef){
                    end.linkTo(parent.end)
                    top.linkTo(name.top)
                },
                icon = AppIcons.editIcon,
                onClick = {
                    onEditIconClicked.invoke(id)
                },
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.25f),
                        Color.Transparent.copy(alpha = 0.12f),
                    )
                )
            )
            GlassIconButton(
                modifier = Modifier.constrainAs(deleteButtonRef){
                    end.linkTo(editButtonRef.end)
                    top.linkTo(editButtonRef.bottom, margin = 12.dp)
                    bottom.linkTo(paymentStatusRef.bottom)
                },
                icon = AppIcons.deleteIcon,
                onClick = {onDeleteIconClicked.invoke(id)},
                brush = Brush.linearGradient(
                    colors = listOf(
                        LiquidGlassColors.Error.copy(alpha = 0.20f),
                        Color.Transparent.copy(alpha = 0.12f),
                    )
                )
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PaymentCardContentPrev(){
    PaymentCardContent(
        id = "",
        toAccountName = "Nithin",
        descriptionText = "For Zomato Order",
        dayInWeek = "Wednesday",
        day = "26",
        month = "August",
        year = "2026",
        paymentStatus = PaymentStatus.RECEIVED,
        syncStatus = SyncStatus.PENDING,
        amount = 1000.00,
        onEditIconClicked = {},
        onDeleteIconClicked = {}
    )
}