package com.nithin.core.common.ui.dialogs

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Stable
sealed class DialogType(val icon: ImageVector, val iconColor: Color){
    data class WarningIcon(val dialogIcon: ImageVector,val color: Color): DialogType(dialogIcon,color)
    data class SuccessIcon(val dialogIcon: ImageVector, val color: Color): DialogType(dialogIcon,color)
    data object DeleteIcon: DialogType(icon = AppIcons.delete_icon, iconColor = LiquidGlassColors.Error)
}