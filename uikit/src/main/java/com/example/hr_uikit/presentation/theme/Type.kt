package com.example.hr_uikit.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hr_uikit.R

val typography = FontFamily(
    Font(R.font.manrope, weight = FontWeight.Normal),
    Font(R.font.manrope_bold, weight = FontWeight.Bold),
    Font(R.font.manrope_medium, weight = FontWeight.Medium),
    Font(R.font.manrope_semibold, weight = FontWeight.SemiBold)
)

@Immutable
data class CustomTypography(
    val ScreenHeader24px: TextStyle =
        TextStyle(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = (-0.48).sp,
            fontWeight = FontWeight.Bold,
            fontFamily = typography
        ),
    val Subheader18px: TextStyle =
        TextStyle(
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = (-0.18).sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = typography
        ),
    val BodyMedium16px: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0).sp,
        fontWeight = FontWeight.Normal,
        fontFamily = typography
    ),
    val BodySmall14px: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0).sp,
        fontWeight = FontWeight.Normal,
        fontFamily = typography
    ),
    val FieldLabel14pxBold: TextStyle=TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0).sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = typography
    ),
)

val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography()
}