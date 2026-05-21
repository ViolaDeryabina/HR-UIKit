package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hr_uikit.presentation.theme.CustomTheme

// Назначение: Создание кнопки PrimaryButton для обработки нажатий
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick:()-> Unit,
    text: String,
    enabled: Boolean
) {
    Log.i("[PrimaryButton]","Создание - Отрисовка кнопки")

    MainButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        enabled = enabled
    )
}

@Preview
@Composable
private fun PrimaryButtonPrev() {
    CustomTheme{
        PrimaryButton(
            onClick = {},
            text = "sadddddddddsdd",
            enabled = true,
            modifier = Modifier.width(100.dp)
        )
    }
}