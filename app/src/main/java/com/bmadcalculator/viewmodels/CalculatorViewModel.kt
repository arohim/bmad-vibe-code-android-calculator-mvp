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
     * Resets the calculator to its default state
     */
    fun reset() {
        calculatorModel.reset()
        displayValue = calculatorModel.displayValue
    }
}