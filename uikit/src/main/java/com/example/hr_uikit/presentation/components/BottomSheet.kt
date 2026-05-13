package com.example.hr_uikit.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hr_uikit.presentation.model.BottomSheetData
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.Secondary
import com.example.hr_uikit.presentation.theme.White

// Назначение: Создание элемента BottomSheet для выбора
// Автор: Дерябина В.Н.
// Дата создания 13-05-2026
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    listString: List<BottomSheetData> = listOf
        (
        BottomSheetData("New Applicants", selected = true, id = 0),
        BottomSheetData("New Applicants", selected = false, id = 1),
        BottomSheetData("New Applicants", selected = false, id = 2),
        BottomSheetData("New Applicants", selected = false, id = 3),
        BottomSheetData("New Applicants", selected = false, id = 4),
        BottomSheetData("New Applicants", selected = false, id = 5)
    ),
    onDismissRequest: () -> Unit,
    onClickCancel: () -> Unit = {},
    onClickUpdate: () -> Unit = {},
    onItemSelected: (BottomSheetData) -> Unit,
) {
    Log.i("[BottomSheet]", "Создание - Отрисовка BottomSheet")

    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        },
        sheetState = sheetState,
        modifier = modifier,
        containerColor = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            listString.forEach { it ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        .background(
                            if (it.selected) Color(0xFFEFF6FF).copy(0.5f) else White,
                            RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Text(
                        text = it.title,
                        style = CustomTheme.typography.BodySmall14px,
                        color = Secondary,
                        fontSize = 16.sp
                    )
                    RadioButton(
                        selected = it.selected,
                        onClick = {

                            onItemSelected(it)
                        },
                        enabled = true,
                        colors = RadioButtonColors(
                            selectedColor = Primary,
                            unselectedColor = Color(0xFF737686),
                            disabledSelectedColor = Color(0xFF737686),
                            disabledUnselectedColor = Color(0xFF737686)
                        ),
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SecondaryButton(onClick = { onClickCancel() }, text = "Cancel", enabled = true)
                PrimaryButton(onClick = { onClickUpdate() }, text = "Update Status", enabled = true)
            }
        }
    }
}

@Preview
@Composable
private fun BottomSheetPrev() {
    CustomTheme {
        var showBottomSheet by remember { mutableStateOf(true) }

        var listState by remember {
            mutableStateOf(
                listOf(
                    BottomSheetData("New Applicants", selected = true, id = 0),
                    BottomSheetData("New Applicants", selected = false, id = 1),
                    BottomSheetData("New Applicants", selected = false, id = 2),
                    BottomSheetData("New Applicants", selected = false, id = 3),
                    BottomSheetData("New Applicants", selected = false, id = 4),
                    BottomSheetData("New Applicants", selected = false, id = 5)
                )
            )
        }

        Box {
            if (showBottomSheet) {
                BottomSheet(
                    listString = listState,
                    onDismissRequest = { showBottomSheet = false },
                    onItemSelected = { clickedItem ->
                        // Главная логика: true ставится ТОЛЬКО совпавшему id, остальные сбрасываются в false
                        listState = listState.map { it.copy(selected = it.id == clickedItem.id) }
                    },
                    onClickCancel = { showBottomSheet = false },
                    onClickUpdate = { showBottomSheet = false }
                )
            }
        }
    }
}