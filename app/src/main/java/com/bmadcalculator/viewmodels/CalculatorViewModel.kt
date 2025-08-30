package com.bmadcalculator.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bmadcalculator.models.CalculatorModel

/**
 * CalculatorViewModel manages the calculator's UI state and coordinates with the CalculatorModel.
 * Implements the MVVM pattern as specified in the architecture documents.
 * 
 * As per Story 1.1 requirements:
 * - Manages displayValue state property (supports both input expression and results)
 * - Provides onNumberClick() function with character limit validation
 * - Enables real-time display updates through state management
 * 
 * As per Story 1.2 requirements:
 * - Provides onOperatorClick() function for handling operator input
 * - Provides onEqualsClick() function for performing calculations
 * - Manages expression building and result display states
 */
class CalculatorViewModel : ViewModel() {
    private val calculatorModel = CalculatorModel()
    
    /**
     * The current display value shown to the user.
     * Serves dual purpose: shows input expression as user types, and calculation results.
     * Automatically triggers UI recomposition when updated.
     */
    var displayValue by mutableStateOf(calculatorModel.displayValue)
        private set
    
    /**
     * Handles number button clicks from the UI.
     * Updates the display value immediately for real-time feedback.
     * 
     * @param digit The digit (0-9) that was clicked
     */
    fun onNumberClick(digit: String) {
        displayValue = calculatorModel.appendNumber(digit)
    }
    
    /**
     * Handles operator button clicks from the UI.
     * Updates the display value to show the building expression.
     * 
     * @param operator The operator symbol that was clicked (e.g., "+")
     */
    fun onOperatorClick(operator: String) {
        displayValue = calculatorModel.appendOperator(operator)
    }
    
    /**
     * Handles equals button clicks from the UI.
     * Performs the calculation and updates the display with the result.
     */
    fun onEqualsClick() {
        displayValue = calculatorModel.calculate()
    }
    
    /**
     * Resets the calculator to its default state
     */
    fun reset() {
        calculatorModel.reset()
        displayValue = calculatorModel.displayValue
    }
}