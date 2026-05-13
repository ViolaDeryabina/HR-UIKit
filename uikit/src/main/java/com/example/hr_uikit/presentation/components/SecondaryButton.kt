package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.White

// Назначение: Создание кнопки SecondaryButton для обработки нажатий
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick:()-> Unit,
    text: String,
    enabled: Boolean
) {
    Log.i("[SecondaryButton]","Создание - Отрисовка кнопки")
    MainButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonColors(
            containerColor = White,
            contentColor = Primary,
            disabledContentColor = Primary,
            disabledContainerColor = White
        ),
        border = BorderStroke(2.dp, Primary),
        color = Primary
    )
}

@Preview
@Composable
private fun SecondaryButtonPrev() {
    CustomTheme {
        SecondaryButton(
            onClick = {},
            text = "TExt",
            enabled = true
        )
    }
}