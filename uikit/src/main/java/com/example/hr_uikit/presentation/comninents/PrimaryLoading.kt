package com.example.hr_uikit.presentation.comninents

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hr_uikit.presentation.theme.CustomTheme

// Назначение: Создание кнопки PrimaryLoading для обработки нажатий
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun PrimaryLoading(
    modifier: Modifier = Modifier,
    onClick:()-> Unit,
    text: String,
    enabled: Boolean
) {
    Log.i("[PrimaryLoading]","Создание - Отрисовка кнопки")

    MainButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        enabled = enabled,
        loading = true
    )
}

@Preview
@Composable
private fun PrimaryLoadingPrev() {
    CustomTheme{
        PrimaryLoading(onClick = {},
            text = "TExt",
            enabled = true)
    }
}