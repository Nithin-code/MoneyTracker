package com.nithin.core.common.ui.design_system

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.FontSize
import com.nithin.core.common.ui.themes.LiquidGlassColors


@Composable
fun StatusChip(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color,
    textColor: Color,
){
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.padding(
                horizontal = 8.dp,
                vertical = 4.dp
            ),
            text = text,
            fontSize = FontSize.chipFontSize,
            color = textColor
        )
    }
}

@Composable
fun StatusGlassChip(
    modifier: Modifier = Modifier,
    paymentStatus: PaymentStatus
){
    when(paymentStatus){
        PaymentStatus.SENT -> {
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        LiquidGlassColors.Error.copy(alpha = 0.20f)
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            ) {

                Text(
                    text = "Sent",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = LiquidGlassColors.Error
                )
            }
        }
        PaymentStatus.RECEIVED -> {
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        LiquidGlassColors.Success.copy(alpha = 0.20f)
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            ) {

                Text(
                    text = "Received",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = LiquidGlassColors.Success
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev(){
    StatusGlassChip(
        paymentStatus = PaymentStatus.SENT
    )
}