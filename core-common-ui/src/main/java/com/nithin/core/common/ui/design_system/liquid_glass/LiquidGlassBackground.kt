package com.nithin.core.common.ui.design_system.liquid_glass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun LiquidGlassBackground(
    modifier: Modifier = Modifier,
    content : @Composable ()-> Unit
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        LiquidGlassColors.Background,
                        LiquidGlassColors.BackgroundSecondary,
                        LiquidGlassColors.Background
                    )
                )
            )
    ){
        Box(
            modifier = Modifier
                .size(320.dp)
                .offset(
                    x = (-100).dp,
                    y = 100.dp
                )
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            LiquidGlassColors.Primary.copy(0.45f),
                            Color.Transparent
                        )
                    )
                )

        )

        Box(
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.BottomEnd)
                .offset(
                    x = 80.dp,
                    y = 80.dp
                )
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            LiquidGlassColors.Purple.copy(0.35f),
                            Color.Transparent
                        )
                    )
                )

        )

        content()

    }
}

@Preview(showBackground = true)
@Composable
fun LiquidGlassBackgroundPrev(){
    LiquidGlassBackground{

    }
}