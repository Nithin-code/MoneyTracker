package com.nithin.core.common.ui.design_system

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nithin.core.common.ui.dialogs.DialogType
import com.nithin.core.common.ui.themes.LiquidGlassColors

@Composable
fun CustomDialog(
    id: String? = null,
    dialogTitle: String,
    dialogDescription: String,
    onConfirmButtonClicked:(String?)-> Unit,
    onDismissButtonClicked:()-> Unit,
    dialogType: DialogType,
){

    Dialog(
        onDismissRequest = onDismissButtonClicked,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF6C72B5).copy(alpha = 0.72f),
                            Color(0xFF5367A8).copy(alpha = 0.68f),
                            Color(0xFF456A9D).copy(alpha = 0.64f)
                        )
                    )
                )
                .border(
                    width = 1.dp,
                    color = LiquidGlassColors.GlassWhite,
                    shape = RoundedCornerShape(20.dp)
                )
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ){
                    Box(
                        modifier = Modifier.size(36.dp)
                            .clip(CircleShape)
                            .background(
                                brush = Brush.radialGradient(
                                    colors = listOf(
                                        dialogType.iconColor.copy(alpha = 0.45f),
                                        Color.Transparent,
                                    )
                                )
                            )
                    )

                    Icon(
                        modifier = Modifier
                            .size(28.dp),
                        imageVector = dialogType.icon,
                        contentDescription = (null),
                        tint = dialogType.iconColor
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = dialogTitle,
                    fontWeight = FontWeight.Bold,
                    color = LiquidGlassColors.GlassWhite
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = dialogDescription,
                    fontWeight = FontWeight.Normal,
                    color = LiquidGlassColors.GlassWhite
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.align(Alignment.End)
                        .padding(horizontal = 20.dp)
                ) {
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

                    Spacer(modifier = Modifier.width(12.dp))
                    TextButton(
                        onClick = {
                            onConfirmButtonClicked.invoke(id)
                        },
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
                }

            }
        }
    }

}