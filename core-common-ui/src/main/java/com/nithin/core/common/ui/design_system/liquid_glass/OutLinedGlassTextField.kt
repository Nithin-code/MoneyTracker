package com.nithin.core.common.ui.design_system.liquid_glass

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.icons.AppIconType
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun OutLinedGlassTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged:(String)-> Unit,
    icon: AppIconType,
    hint: String,
    imeAction: ImeAction,
    keyboardType: KeyboardType,
){
    OutlinedTextField(
        value = text,
        onValueChange = onTextChanged,
        label = { Text(text = hint) },
        leadingIcon = {
            when(icon) {
                is AppIconType.Drawable -> {
                    Icon(
                        painter = painterResource(icon.icon),
                        contentDescription = null
                    )
                }
                is AppIconType.ImageVector -> {
                    Icon(
                        imageVector = icon.icon,
                        contentDescription = null
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = LiquidGlassColors.TextPrimary,
            unfocusedTextColor = LiquidGlassColors.TextSecondary,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedBorderColor = LiquidGlassColors.GlassWhite,
            unfocusedBorderColor = LiquidGlassColors.GlassWhite.copy(alpha = 0.12f),
            focusedLeadingIconColor = LiquidGlassColors.GlassWhite,
            unfocusedLeadingIconColor = LiquidGlassColors.GlassWhite,
            focusedLabelColor = LiquidGlassColors.GlassWhite,
            unfocusedLabelColor = LiquidGlassColors.GlassWhite
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction,
            keyboardType = keyboardType
        )
    )
}


@Preview(showBackground = false)
@Composable
fun OutLinedGlassTextFieldPrev(){
    OutLinedGlassTextField(
        modifier = Modifier.fillMaxWidth(),
        text = "Name",
        onTextChanged = {},
        icon = AppIconType.ImageVector(AppIcons.contactIcon),
        hint = "Name",
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Text
    )
}
