package com.bmadcalculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * CalculatorKeypad composable provides the numeric input and operation interface.
 * 
 * As per Story 1.1 requirements:
 * - 4x3 grid layout with numbers arranged as specified:
 *   Row 1: 1, 2, 3
 *   Row 2: 4, 5, 6  
 *   Row 3: 7, 8, 9
 *   Row 4: 0 (spanning center position)
 * - Immediate display updates when buttons are tapped
 * - Proper sizing and spacing for touch interaction
 * 
 * As per Story 1.2 requirements:
 * - Addition operator ("+") button in row 1
 * - Equals ("=") button in row 4
 * - Proper styling to match existing numeric buttons
 */
@Composable
fun CalculatorKeypad(
    onNumberClick: (String) -> Unit,
    onOperatorClick: (String) -> Unit,
    onEqualsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Row 1: 1, 2, 3, +
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                text = "1",
                onClick = { onNumberClick("1") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                text = "2",
                onClick = { onNumberClick("2") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                text = "3",
                onClick = { onNumberClick("3") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                text = "+",
                onClick = { onOperatorClick("+") },
                modifier = Modifier.weight(1f),
                isOperator = true
            )
        }
        
        // Row 2: 4, 5, 6
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                text = "4",
                onClick = { onNumberClick("4") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                text = "5",
                onClick = { onNumberClick("5") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                text = "6",
                onClick = { onNumberClick("6") },
                modifier = Modifier.weight(1f)
            )
        }
        
        // Row 3: 7, 8, 9
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                text = "7",
                onClick = { onNumberClick("7") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                text = "8",
                onClick = { onNumberClick("8") },
                modifier = Modifier.weight(1f)
            )
            CalculatorButton(
                text = "9",
                onClick = { onNumberClick("9") },
                modifier = Modifier.weight(1f)
            )
        }
        
        // Row 4: 0, =
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Empty space for left alignment
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(1f))
            
            CalculatorButton(
                text = "0",
                onClick = { onNumberClick("0") },
                modifier = Modifier.weight(1f)
            )
            
            CalculatorButton(
                text = "=",
                onClick = { onEqualsClick() },
                modifier = Modifier.weight(1f),
                isOperator = true
            )
            
            // Empty space for right alignment
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(1f))
        }
    }
}

/**
 * Individual calculator button composable with consistent styling.
 * Supports different styling for operators vs numbers.
 */
@Composable
private fun CalculatorButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isOperator: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .aspectRatio(1f),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isOperator) MaterialTheme.colorScheme.primary else Color.LightGray,
            contentColor = if (isOperator) MaterialTheme.colorScheme.onPrimary else Color.Black
        )
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}