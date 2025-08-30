package com.bmadcalculator.models

/**
 * Data class representing a completed calculation for history storage.
 * 
 * As per Story 1.2 requirements:
 * - Stores the full expression (e.g., "2+3")
 * - Stores the calculated result (e.g., "5")
 * - Used by CalculatorModel's history management
 * 
 * @param expression The mathematical expression that was evaluated
 * @param result The computed result of the expression
 */
data class Calculation(
    val expression: String,
    val result: String
)