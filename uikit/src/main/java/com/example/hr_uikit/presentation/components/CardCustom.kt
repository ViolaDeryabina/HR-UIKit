package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hr_uikit.R
import com.example.hr_uikit.data.CardCustom
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Secondary
import com.example.hr_uikit.presentation.theme.Text
import com.example.hr_uikit.presentation.theme.White

// Назначение: Создание элемента CardCustom для просмотра информации
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@Composable
fun CardCustom(
    modifier: Modifier = Modifier,
    information: CardCustom = CardCustom(
        textTitle = "Senior Product Designer",
        category = "Product Team",
        time = "Full-time",
        status = "Active",
        money = "\$120k - \$160k",
        people = 1
    ),
    background: Color = Color(0xFFD0E1FB),

    ) {
    Log.i("[CardCustom]", "Создание - Отрисовка CardCustom")

    Card(
        modifier = modifier,
        colors = CardColors(
            containerColor = White,
            disabledContainerColor = White,
            contentColor = Text,
            disabledContentColor = Text
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        text = information.textTitle,
                        style = CustomTheme.typography.ScreenHeader24px,
                        color = Text
                    )
                    Row() {
                        Text(
                            text = "${information.textTitle}  • ${information.time}",
                            style = CustomTheme.typography.BodySmall14px,
                            color = Secondary
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(background, CircleShape)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = information.status,
                        style = CustomTheme.typography.BodyMedium16px,
                        color = Secondary,
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(33.dp))
            Row() {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.money),
                    contentDescription = "",
                    tint = Secondary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = information.money,
                    style = CustomTheme.typography.FieldLabel14pxBold,
                    color = Secondary,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(24.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.people),
                    contentDescription = "",
                    tint = Secondary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${information.people} Applicants",
                    style = CustomTheme.typography.BodySmall14px,
                    color = Secondary,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardCustomPrev() {
    CustomTheme {
        CardCustom(
            modifier = Modifier.fillMaxWidth()
        )
    }
}