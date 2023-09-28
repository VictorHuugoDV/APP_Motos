package com.example.motos.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.motos.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val lilitaone = FontFamily(Font(R.font.lilitaone_regular))

val typography = Typography(
    labelLarge = TextStyle(
        fontFamily = lilitaone,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    displayLarge = TextStyle(
        fontFamily = lilitaone,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp
    )
)