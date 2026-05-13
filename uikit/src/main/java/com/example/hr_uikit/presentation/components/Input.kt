package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hr_uikit.presentation.theme.Background
import com.example.hr_uikit.presentation.theme.Border
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Error
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.Text

// Назначение: Создание элемента Input для ввода информации
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean=false,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    textString: String = "",
    textColor: Color= Text
    ) {
    Log.i("[Input]", "Создание - Отрисовка инпута")
    Column() {
        if (textString.isNotEmpty()) {
            Text(
                text = textString,
                style = CustomTheme.typography.BodyMedium16px,
                color = textColor
            )
        }
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Background,
                unfocusedContainerColor = Background,
                disabledContainerColor = Background,

                errorBorderColor = Error,
                focusedBorderColor = Primary,
                unfocusedBorderColor = Border,
                disabledBorderColor = Border
            ),
            shape = RoundedCornerShape(8.dp),
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            isError = isError
            )
    }
}

@Preview
@Composable
private fun InputPrev() {
    CustomTheme {
        Input(
            value = "",
            onValueChange = {},
            placeholder ={
                Text(
                    text = "Active typing state",
                    style = CustomTheme.typography.BodyMedium16px,
                    color = Text
                )
            }
        )
    }
}