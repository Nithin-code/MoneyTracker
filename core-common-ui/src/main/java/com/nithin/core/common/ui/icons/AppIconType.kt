package com.nithin.core.common.ui.icons

import androidx.compose.runtime.Stable

@Stable
sealed interface AppIconType {
    data class ImageVector(val icon: androidx.compose.ui.graphics.vector.ImageVector) : AppIconType
    data class Drawable(val icon: Int): AppIconType
}