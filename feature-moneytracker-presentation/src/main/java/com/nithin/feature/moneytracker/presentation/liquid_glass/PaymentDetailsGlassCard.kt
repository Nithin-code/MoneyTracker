package com.nithin.feature.moneytracker.presentation.liquid_glass

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.data.SyncStatus
import com.nithin.core.common.ui.design_system.StatusChip
import com.nithin.core.common.ui.design_system.StatusGlassChip
import com.nithin.core.common.ui.design_system.liquid_glass.GlassCard
import com.nithin.core.common.ui.design_system.liquid_glass.GlassIconButton
import com.nithin.core.common.ui.design_system.liquid_glass.GlassSyncStatus
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.FontSize
import com.nithin.core.common.ui.themes.LiquidGlassColors
import com.nithin.feature.moneytracker.presentation.views.payments_overview.PaymentDetailsCard

@Composable
fun PaymentDetailsGlassCard(
    modifier: Modifier = Modifier,
    id: String,
    toAccountName: String,
    description: String,
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

    GlassCard(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            PaymentIcon()
            Spacer(
                modifier = Modifier.width(12.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = toAccountName,
                    style = MaterialTheme.typography.titleMedium,
                    color = LiquidGlassColors.TextPrimary
                )
                if (description.isNotBlank()){
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = LiquidGlassColors.TextSecondary,
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = dateString,
                    style = MaterialTheme.typography.labelMedium,
                    color = LiquidGlassColors.TextTertiary,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StatusGlassChip(
                        paymentStatus = paymentStatus
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    GlassSyncStatus(
                        syncStatus = syncStatus
                    )
                }
            }

            Text(
                text = "$amount",
                style = MaterialTheme.typography.titleLarge,
                color = LiquidGlassColors.TextTertiary
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column(
                horizontalAlignment = Alignment.End
            ) {

                GlassIconButton(
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
                Spacer(modifier = Modifier.height(8.dp))
                GlassIconButton(
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

}

@Composable
fun PaymentIcon(
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .size(32.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Transparent,
                        LiquidGlassColors.Primary
                    )
                ),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(AppIcons.AtmCardIconId),
            contentDescription = "atm_card",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentDetailsGlassCardPrev() {
    PaymentDetailsGlassCard(
        id = "",
        toAccountName = "Nithin",
        description = "For Zomato Order",
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