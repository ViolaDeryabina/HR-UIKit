package com.example.hr_uikit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hr_uikit.R
import com.example.hr_uikit.data.BottomBar
import com.example.hr_uikit.presentation.theme.Border
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.White


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selected: Int
) {
    Row(
        modifier = modifier
            .background(White)
            .padding(vertical = 25.5.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        val list = listOf(
            BottomBar(
                icon = R.drawable.dashboard,
                text = "Dashboard",
                id = 0

            ), BottomBar(
                icon = R.drawable.vacancies,
                text = "Vacancies",
                id = 1
            ), BottomBar(
                icon = R.drawable.candidates,
                text = "Candidates",
                id = 2
            )
        )
        list.forEach { it ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = ImageVector.vectorResource(it.icon),
                    contentDescription = "",
                    tint = if (selected == it.id) Primary else Border,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = it.text,
                    style = CustomTheme.typography.BodyMedium16px,
                    fontSize = 11.sp,
                    color = if (selected == it.id) Primary else Border
                )
            }
        }

    }
}

@Preview
@Composable
private fun BottomBarPrev() {
    CustomTheme {
        BottomBar(selected = 1, modifier = Modifier.fillMaxWidth())
    }
}