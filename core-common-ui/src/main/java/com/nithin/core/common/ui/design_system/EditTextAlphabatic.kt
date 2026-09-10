package com.nithin.core.common.ui.design_system

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.core.common.ui.icons.AppIcons
import com.nithin.core.common.ui.themes.AppColors

@Composable
fun EditTextName(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged:(String)-> Unit,
    leadingIcon: ImageVector?,
    leadingIconDrawable: Int?,
    labelText: String,
    maxLines: Int = 1,
    onLeadingIconClicked:()-> Unit,
    iemAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text,
    supportingText: String = ""
){
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChanged,
        leadingIcon = {
            when {
                leadingIcon !=null -> {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(
                            onClick = {
                                onLeadingIconClicked.invoke()
                            }
                        ),
                        imageVector = leadingIcon,
                        contentDescription = "Contacts"
                    )
                }
                leadingIconDrawable!=null->{
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(
                            onClick = {
                                onLeadingIconClicked.invoke()
                            }
                        ),
                        painter = painterResource(leadingIconDrawable),
                        contentDescription = "leading_icon"
                    )
                }
                else -> {}
            }

        },
        label = {
            Text(
                text = labelText
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = iemAction,
            keyboardType = keyboardType
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = AppColors.primaryBackground,
            unfocusedContainerColor = AppColors.summaryBarColor
        ),
        maxLines = maxLines,
        supportingText = {
            Text(
                text = supportingText,
                color = AppColors.statusSentTextColor
            )
        }
    )

}

@Preview(showBackground = true)
@Composable
fun EditTextPrev(){

}