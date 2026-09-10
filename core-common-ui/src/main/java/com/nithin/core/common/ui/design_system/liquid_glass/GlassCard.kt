package com.nithin.core.common.ui.design_system.liquid_glass

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    content: @Composable ()-> Unit
){

    Column(
        modifier = modifier
            .clip(shape)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.2f),
                        Color.White.copy(alpha = 0.08f),
                    )
                )
            )
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.30f),
                shape = shape
            )
            .shadow(
                elevation = 10.dp,
                shape = shape,
                ambientColor = Color.Black.copy(0.20f),
                spotColor = Color.Black.copy(alpha = 0.30f)
            )
            .padding(16.dp),
    ){
        content.invoke()
    }

}

@Preview(showBackground = true)
@Composable
fun GlassCardPrev(){
    GlassCard(
        modifier = Modifier.fillMaxWidth().size(100.dp)
    ){

    }
}