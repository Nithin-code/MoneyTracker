package com.nithin.core.common.ui.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun LiquidGlassDialog(
    dialogTitle: String,
    dialogDescription: String,
    dialogIcon: ImageVector,
    onConfirmButtonClicked:()-> Unit,
    onDismissButtonClicked:()-> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Transparent,
                        LiquidGlassColors.GlassWhite.copy(alpha = 0.12f)
                    )
                )
            )
            .border(
                width = 1.dp,
                color = LiquidGlassColors.GlassWhite
            )
    ){
        AlertDialog(
            onDismissRequest = onDismissButtonClicked,
            confirmButton = {
                TextButton(
                    onClick = onConfirmButtonClicked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LiquidGlassColors.PrimaryLight,
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = LiquidGlassColors.GlassWhite
                    )
                ) {
                    Text(
                        text = "Ok"
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissButtonClicked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Cancel"
                    )
                }
            },
            icon = {
                Icon(
                    imageVector = dialogIcon,
                    contentDescription = null
                )
            },
            title = {
                Text(
                    text = dialogTitle,
                    color = LiquidGlassColors.GlassWhite,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = dialogDescription,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = LiquidGlassColors.GlassWhite,
                )
            },
            containerColor = Color.Transparent,
            iconContentColor = LiquidGlassColors.Warning
        )
    }
}






@Preview(showBackground = true)
@Composable
fun LiquidGlassDialogPrev() = LiquidGlassDialog(
    dialogTitle = "Invalid",
    dialogDescription = "Please Enter Valid Name",
    dialogIcon = AppIcons.warningIcon,
    onConfirmButtonClicked = {},
    onDismissButtonClicked = {}
)