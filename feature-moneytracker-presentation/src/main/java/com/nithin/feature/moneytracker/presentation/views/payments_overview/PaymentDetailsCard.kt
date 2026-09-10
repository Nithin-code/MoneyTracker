package com.nithin.feature.moneytracker.presentation.views.payments_overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.data.SyncStatus
import com.nithin.core.common.ui.design_system.StatusChip
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.FontSize

@Composable
internal fun PaymentDetailsCard(
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
    onEditIconClicked: (String) -> Unit
) {
    val chipBackgroundColor = remember {
        if (paymentStatus == PaymentStatus.RECEIVED) AppColors.statusReceivedBackgroundColor
        else AppColors.statusSentBackgroundColor
    }

    val chipTextColor = remember {
        if (paymentStatus == PaymentStatus.RECEIVED) AppColors.statusReceivedTextColor
        else AppColors.statusSentTextColor
    }

    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(vertical = 8.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        color = Color.Transparent,
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
            PaymentDetailsColum(
                modifier = Modifier.weight(1f),
                toAccountName = toAccountName,
                description = description,
                dayInWeek = dayInWeek,
                day = day,
                month = month,
                year = year,
                paymentStatus = paymentStatus,
                syncStatus = syncStatus,
                chipBackgroundColor = chipBackgroundColor,
                chipTextColor = chipTextColor
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = "$amount",
                    fontSize = FontSize.screenFontSize
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = AppIcons.editIcon,
                        contentDescription = "Edit Icon",
                        tint = AppColors.primaryButton,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { onEditIconClicked.invoke(id) }
                    )
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                    Icon(
                        imageVector = AppIcons.deleteIcon,
                        contentDescription = "Edit Icon",
                        tint = AppColors.primaryButton,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { onDeleteIconClicked.invoke(id) }
                    )


                }
            }
        }
    }
}

@Composable
fun PaymentDetailsColum(
    modifier: Modifier = Modifier,
    toAccountName: String,
    description: String,
    dayInWeek: String,
    day: String,
    month: String,
    year: String,
    paymentStatus: PaymentStatus,
    syncStatus: SyncStatus,
    chipBackgroundColor: Color,
    chipTextColor: Color
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = toAccountName,
            fontSize = FontSize.nameFontSize,
            color = AppColors.primaryText
        )
        if (description.isNotBlank()) {
            Text(
                text = description,
                fontSize = FontSize.descriptionFontSize,
                color = AppColors.secondaryText
            )
        }
        Text(
            text = "$dayInWeek, $month $day, $year",
            fontSize = FontSize.descriptionFontSize,
            color = AppColors.secondaryText
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            StatusChip(
                text = paymentStatus.status,
                backgroundColor = chipBackgroundColor,
                textColor = chipTextColor
            )
            Text(
                text = "Sync",
                fontSize = FontSize.descriptionFontSize,
                color = AppColors.secondaryText
            )
            Icon(
                imageVector = AppIcons.SyncSuccessfulIcon,
                contentDescription = "sync_successful",
                tint = if (syncStatus == SyncStatus.COMPLETED) AppColors.totalAmountColor else AppColors.syncStatusPendingColor,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentDetailsCardPrev() {
    PaymentDetailsCard(
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