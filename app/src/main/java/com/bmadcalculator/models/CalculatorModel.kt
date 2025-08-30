package com.bmadcalculator.models

/**
 * CalculatorModel handles the core business logic for the calculator application.
 * This includes input processing, expression evaluation, and calculation history.
 * 
 * As per Story 1.1 requirements:
 * - Handles number input appending with overflow protection
 * - Maintains single display value for both input expression and results
 * - Enforces 12-character maximum length constraint
 * 
 * As per Story 1.2 requirements:
 * - Implements calculation engine for addition operations
 * - Manages expression building and parsing
 * - Stores calculation history
 */
class CalculatorModel {
    companion object {
        const val MAX_DISPLAY_LENGTH = 12
        const val DEFAULT_DISPLAY_VALUE = "0"
    }
    
    private var _displayValue: String = DEFAULT_DISPLAY_VALUE
    val displayValue: String get() = _displayValue
    
    private var _currentExpression: String = ""
    private var _firstOperand: String = ""
    private var _operator: String = ""
    private var _isWaitingForOperand: Boolean = false
    
    private val _calculationHistory = mutableListOf<Calculation>()
    val calculationHistory: List<Calculation> get() = _calculationHistory.toList()
    
    /**
     * Appends a number digit to the current display expression.
     * Implements overflow protection to prevent input beyond MAX_DISPLAY_LENGTH characters.
     * 
     * @param digit The digit (0-9) to append to the display
     * @return The updated display value
     */
    fun appendNumber(digit: String): String {
        // If we're showing the default "0" or waiting for a new operand after operator
        if (_displayValue == DEFAULT_DISPLAY_VALUE || _isWaitingForOperand) {
            _displayValue = digit
            _isWaitingForOperand = false
        } else {
            // Only append if we haven't reached the character limit
            if (_displayValue.length < MAX_DISPLAY_LENGTH) {
                _displayValue += digit
            }
        }
        return _displayValue
    }
    
    /**
     * Handles operator input for building expressions.
     * Updates display to show the current expression being built.
     * 
     * @param operator The operator symbol (e.g., "+")
     * @return The updated display value showing the expression
     */
    fun appendOperator(operator: String): String {
        // Store the current display value as the first operand
        _firstOperand = _displayValue
        _operator = operator
        
        // Build the expression display: "2+"
        _currentExpression = "$_firstOperand$operator"
        
        // Check if the expression fits in the display limit
        if (_currentExpression.length <= MAX_DISPLAY_LENGTH) {
            _displayValue = _currentExpression
        }
        
        _isWaitingForOperand = true
        return _displayValue
    }
    
    /**
     * Performs calculation and returns the result.
     * Adds completed calculation to history.
     * 
     * @return The calculated result
     */
    fun calculate(): String {
        if (_firstOperand.isEmpty() || _operator.isEmpty()) {
            return _displayValue
        }
        
        val secondOperand = if (_isWaitingForOperand) _firstOperand else _displayValue
        
        val result = when (_operator) {
            "+" -> {
                val first = _firstOperand.toDoubleOrNull() ?: 0.0
                val second = secondOperand.toDoubleOrNull() ?: 0.0
                val sum = first + second
                
                // Format result to remove unnecessary decimal places
                if (sum == sum.toLong().toDouble()) {
                    sum.toLong().toString()
                } else {
                    sum.toString()
                }
            }
            else -> _displayValue
        }
        
        // Build the full expression for history
        val fullExpression = "$_firstOperand$_operator$secondOperand"
        
        // Add to history
        _calculationHistory.add(Calculation(fullExpression, result))
        
        // Update display with result
        _displayValue = if (result.length <= MAX_DISPLAY_LENGTH) result else result.take(MAX_DISPLAY_LENGTH)
        
        // Reset state for next calculation
        _currentExpression = ""
        _firstOperand = ""
        _operator = ""
        _isWaitingForOperand = false
        
        return _displayValue
    }
    
    /**
     * Resets the calculator to its default state
     */
    fun reset() {
        _displayValue = DEFAULT_DISPLAY_VALUE
        _currentExpression = ""
        _firstOperand = ""
        _operator = ""
        _isWaitingForOperand = false
    }
}