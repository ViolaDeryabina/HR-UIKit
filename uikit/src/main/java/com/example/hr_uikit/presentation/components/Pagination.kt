package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary

// Назначение: Создание элемента Pagination для визуализации перехода
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun Pagination(currentPageIndex: Int, modifier: Modifier = Modifier, progress: Boolean=false) {
    Log.i("[Pagination]", "Создание - Отрисовка Pagination")
    Row() {
        repeat(3) { iteration ->
            val color =
                if (currentPageIndex == iteration) Primary
                else if (currentPageIndex + 1 == iteration && progress) Primary.copy(
                    0.5f
                )else if(currentPageIndex > iteration && progress)Primary else Color(0xFFE1E2ED)
            Box(
                modifier = modifier
                    .weight(1f)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .height(8.dp)
            )
        }
    }

}

@Preview
@Composable
private fun PaginationPrev() {
    CustomTheme {
        Column() {
            Pagination(currentPageIndex = 0)
            Pagination(currentPageIndex = 1)
            Pagination(currentPageIndex = 2)
        }
    }
}