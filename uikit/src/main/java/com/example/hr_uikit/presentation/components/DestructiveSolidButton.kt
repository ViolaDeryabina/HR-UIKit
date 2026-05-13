package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Error
import com.example.hr_uikit.presentation.theme.White

// Назначение: Создание кнопки DestructiveSolidButton для обработки нажатий
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun DestructiveSolidButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean
) {
    Log.i("[DestructiveSolidButton]", "Создание - Отрисовка кнопки")
    MainButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonColors(
            containerColor = Error,
            contentColor = White,
            disabledContentColor = Error,
            disabledContainerColor = White
        )
    )
}

@Preview
@Composable
private fun DestructiveSolidButtonPrev() {
    CustomTheme {
        DestructiveSolidButton(
            onClick = {},
            text = "TExt",
            enabled = true)

    }
}