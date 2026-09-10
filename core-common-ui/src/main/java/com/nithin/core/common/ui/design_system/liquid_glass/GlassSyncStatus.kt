package com.nithin.core.common.ui.design_system.liquid_glass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.core.common.data.SyncStatus
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun GlassSyncStatus(
    modifier: Modifier = Modifier,
    syncStatus: SyncStatus
){

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Sync",
            fontSize = 12.sp,
            color = LiquidGlassColors.TextSecondary
        )
        Spacer(
            modifier = Modifier.width(5.dp)
        )
        when(syncStatus) {
            SyncStatus.PENDING -> {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(
                            AppColors.syncStatusPendingColor
                        )
                ) {

                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                    )
                }
            }
            SyncStatus.COMPLETED -> {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(
                            LiquidGlassColors.Success
                        )
                ) {

                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                    )
                }
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun GlassSyncStatusPrev(){
    GlassSyncStatus(
        syncStatus = SyncStatus.PENDING
    )
}
