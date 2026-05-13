package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hr_uikit.R
import com.example.hr_uikit.presentation.theme.Border
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.Text

// Назначение: Создание элемента Avatar для отображения фото пользователя
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun Avatar(
    bitmap: ImageBitmap?,
    name: String,
    modifier: Modifier = Modifier,
    nameShort: String = "",

    ) {
    Log.i("[Avatar]", "Создание - Отрисовка Avatar")
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        if (bitmap != null) {
            Image(
                bitmap = bitmap,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp)
                    .border(2.dp, Primary, CircleShape)
            )
        } else {
            Box(
                modifier = Modifier
                    .background(Color(0xFFD3E4FE), CircleShape)
                    .size(64.dp)
                    .border(2.dp, Border, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = nameShort,
                    style = CustomTheme.typography.BodyMedium16px,
                    fontSize = 12.sp,
                    color = Text
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            style = CustomTheme.typography.BodyMedium16px,
            fontSize = 12.sp,
            color = Text
        )
    }
}

@Preview
@Composable
private fun AvatarPrev() {
    CustomTheme {
        Column() {
            Avatar(
                name = "FIO",
                bitmap = ImageBitmap.imageResource(R.drawable.candidate_avatar)
            )
            Avatar(
                name = "FIO",
                bitmap = null
            )
        }
    }
}