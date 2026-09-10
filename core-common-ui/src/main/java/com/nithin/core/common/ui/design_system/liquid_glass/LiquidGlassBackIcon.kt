package com.nithin.core.common.ui.design_system.liquid_glass

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun LiquidGlassBackIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Box(
        modifier = modifier
            .size(42.dp)
            .clip(CircleShape)
            .clickable{
                onClick()
            }
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        LiquidGlassColors.Background.copy(alpha = 0.12f),
                        Color.Transparent
                    )
                )
            )
            .border(
                width = 1.dp,
                color = LiquidGlassColors.GlassWhite,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = AppIcons.backIcon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = LiquidGlassColors.GlassWhite
        )
    }


}

@Composable
@Preview(showBackground = false)
fun LiquidGlassBackIconPrev(){
    LiquidGlassBackIcon(
        onClick = {}
    )
}