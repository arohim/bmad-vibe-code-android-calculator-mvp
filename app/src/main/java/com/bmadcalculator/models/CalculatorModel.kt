package com.bmadcalculator.models

/**
 * CalculatorModel handles the core business logic for the calculator application.
 * This includes input processing and maintaining the expression state.
 * 
 * As per Story 1.1 requirements:
 * - Handles number input appending with overflow protection
 * - Maintains single display value for both input expression and results
 * - Enforces 12-character maximum length constraint
 */
class CalculatorModel {
    companion object {
        const val MAX_DISPLAY_LENGTH = 12
        const val DEFAULT_DISPLAY_VALUE = "0"
    }
    
    private var _displayValue: String = DEFAULT_DISPLAY_VALUE
    val displayValue: String get() = _displayValue
    
    /**
     * Appends a number digit to the current display expression.
     * Implements overflow protection to prevent input beyond MAX_DISPLAY_LENGTH characters.
     * 
     * @param digit The digit (0-9) to append to the display
     * @return The updated display value
     */
    fun appendNumber(digit: String): String {
        // If we're showing the default "0", replace it with the first digit
        if (_displayValue == DEFAULT_DISPLAY_VALUE) {
            _displayValue = digit
        } else {
            // Only append if we haven't reached the character limit
            if (_displayValue.length < MAX_DISPLAY_LENGTH) {
                _displayValue += digit
            }
        }
        return _displayValue
    }
    
    /**
     * Resets the calculator to its default state
     */
    fun reset() {
        _displayValue = DEFAULT_DISPLAY_VALUE
    }
}