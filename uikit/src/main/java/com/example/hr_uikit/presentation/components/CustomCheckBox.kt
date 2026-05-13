package com.example.hr_uikit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.hr_uikit.presentation.theme.Border
import com.example.hr_uikit.presentation.theme.CustomTheme
import com.example.hr_uikit.presentation.theme.Primary
import com.example.hr_uikit.presentation.theme.White

@Composable
fun CustomCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean=false
) {
    Checkbox(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = Primary,
            checkmarkColor = White,
            uncheckedColor = Color(0xFF737686),
            disabledUncheckedColor = Border,
            disabledCheckedColor =Color(0xFFEDEDF9),
            disabledIndeterminateColor = Color(0xFFEDEDF9),
        ),
        enabled = enabled
    )
}

@Preview
@Composable
private fun CustomCheckBoxPrev() {
    CustomTheme{
        Column(modifier = Modifier.fillMaxSize().background(White )){
            CustomCheckBox(checked = true, onCheckedChange = {})
            CustomCheckBox(checked = false, onCheckedChange = {})
        }

    }
}