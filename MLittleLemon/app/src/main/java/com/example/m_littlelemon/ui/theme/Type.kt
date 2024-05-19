package com.example.m_littlelemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.m_littlelemon.R

// Set of Material typography styles to start with
val Typography: Typography
    get() = Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        h1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    )

val fonts = FontFamily(
    Font(R.font.karla_regular, weight = FontWeight.Normal),
    Font(R.font.markazi_text_regular, weight = FontWeight.Normal),
)