package com.example.thirtydaysofopm.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydaysofopm.R


val BBTMartires = FontFamily(
    Font(R.font.bbt_martires_regular),
    Font(R.font.bbt_martires_extra_bold, FontWeight.ExtraBold),
    Font(R.font.bbt_martires_thin, FontWeight.Thin)
)

val PTSansNarrow = FontFamily(
    Font(R.font.ptsans_narrow_regular),
    Font(R.font.ptsans_narrow_bold, FontWeight.Bold)
)

val Typography = Typography(
    displaySmall = TextStyle(
        fontFamily = BBTMartires,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        letterSpacing = 1.2.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = BBTMartires,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        lineHeight = 14.5.sp
    )
)
/*

// Set of Material typography styles to start with
val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = PTSansNarrow,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    displaySmall = TextStyle(
        fontFamily = PTSansNarrow,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = BBTMartires,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = BBTMartires,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = PTSansNarrow,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PTSansNarrow,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = PTSansNarrow,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
    )

)*/
