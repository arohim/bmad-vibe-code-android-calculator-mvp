package com.bmadcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bmadcalculator.ui.CalculatorDisplay
import com.bmadcalculator.ui.CalculatorKeypad
import com.bmadcalculator.ui.theme.BMadCalculatorMVPTheme
import com.bmadcalculator.viewmodels.CalculatorViewModel

/**
 * MainActivity serves as the single activity hosting the calculator UI.
 * Implements the View layer of the MVVM pattern by observing CalculatorViewModel.
 * 
 * As per Story 1.1 requirements:
 * - Uses Jetpack Compose for declarative UI
 * - Integrates CalculatorDisplay and CalculatorKeypad composables
 * - Provides real-time display updates through ViewModel state observation
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMadCalculatorMVPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

/**
 * Main calculator application composable that combines all UI components
 */
@Composable
fun CalculatorApp(
    viewModel: CalculatorViewModel = viewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Display area at the top
            CalculatorDisplay(
                displayValue = viewModel.displayValue
            )
            
            // Keypad taking the remaining space
            CalculatorKeypad(
                onNumberClick = viewModel::onNumberClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorAppPreview() {
    BMadCalculatorMVPTheme {
        CalculatorApp()
    }
}