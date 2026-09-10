package com.nithin.core.common.ui.design_system.liquid_glass

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun GlassIconButton(
    modifier: Modifier= Modifier,
    icon: ImageVector,
    tint: Color = LiquidGlassColors.PrimaryLight,
    onClick:()-> Unit,
    brush: Brush,
){
    IconButton(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier.size(42.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = brush
            )
            .border(
                width = 1.dp,
                Color.White.copy(alpha = 0.25f),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        androidx.compose.material3.Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GlassIconButtonPrev(){
    GlassIconButton(
        icon = AppIcons.deleteIcon,
        onClick = {},
        brush = Brush.linearGradient(
            colors = listOf(
                Color.Red.copy(alpha = 0.25f),
                Color.Transparent.copy(alpha = 0.12f),
            )
        )
    )
}