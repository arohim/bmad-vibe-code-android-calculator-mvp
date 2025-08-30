package com.bmadcalculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * CalculatorDisplay composable displays the current input or result.
 * 
 * As per Story 1.1 requirements:
 * - Single display area serving dual purpose (input expression and results)
 * - Right-aligned text following mathematical convention
 * - Monospace font for consistent digit spacing
 * - Handles 12-character maximum length with overflow protection
 */
@Composable
fun CalculatorDisplay(
    displayValue: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.Black)
            .border(2.dp, Color.Gray)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = displayValue,
            fontSize = 32.sp,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.End,
            maxLines = 1
        )
    }
}