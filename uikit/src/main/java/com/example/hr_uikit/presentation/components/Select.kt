package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hr_uikit.R
import com.example.hr_uikit.presentation.theme.Border
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.Secondary


// Назначение: Создание элемента Select для выбора элемента из BottomSheet
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun Select(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: @Composable (() -> Unit)? = null,
    onClick: () -> Unit={}
) {
    Log.i("[Select]", "Создание - Отрисовка Select")
    Input(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        trailingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.down),
                contentDescription = "",
                tint = Secondary,
                modifier = Modifier
                    .size(12.dp)
                    .clickable(onClick = {onClick()})
            )
        },
        placeholder = placeholder
    )

}

@Preview
@Composable
private fun SelectPrev() {
    CustomTheme {
        Select(value = "", onValueChange = {})
    }
}