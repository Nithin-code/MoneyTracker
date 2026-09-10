package com.nithin.core.common.ui.design_system.liquid_glass

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun PaymentDetailsLiquidGlassCard(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.()-> Unit
){

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.12f),
                        Color.Transparent,
                        Color.White.copy(alpha = 0.12f)
                    )
                ),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = LiquidGlassColors.GlassWhite,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 12.dp, vertical = 12.dp),
        content = content
    )

}

@Composable
@Preview(showBackground = false)
fun PaymentDetailsLiquidGlassPrev(){
    PaymentDetailsLiquidGlassCard(
        modifier = Modifier.fillMaxWidth()
            .height(150.dp)
    ){

    }
}