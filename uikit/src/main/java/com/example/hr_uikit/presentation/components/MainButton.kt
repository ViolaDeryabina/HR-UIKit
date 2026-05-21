package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.Text
import com.example.hr_uikit.presentation.theme.White

// Назначение: Главная кнопка для обработки нажатий
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun MainButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonColors(
        containerColor = Primary,
        contentColor = Text,
        disabledContentColor = Text,
        disabledContainerColor = Primary.copy(0.5f)
    ),
    border: BorderStroke? = null,
    loading: Boolean=false
) {
    Log.i("[MainButton]","Создание - Отрисовка кнопки")
    val context: @Composable () -> Unit = if (loading) {
        {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = White ,
                trackColor = White.copy(0.3f),
                strokeWidth = 2.dp,
                strokeCap = StrokeCap.Butt
            )
        }
    } else {
        {
            Text(
                text,
                style = CustomTheme.typography.BodyMedium16px,
                color = color,
                textAlign = TextAlign.Center
            )
        }
    }
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        onClick = { onClick() },
        border = border,
        enabled = enabled,
        colors = colors
    ) {
        context()
    }

}

@Preview
@Composable
private fun MainButtonPrev() {
    CustomTheme {
        MainButton(onClick = {}, text = "MainButton", loading = true)
    }
}