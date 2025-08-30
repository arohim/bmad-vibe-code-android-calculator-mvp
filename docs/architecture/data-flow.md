# Data Flow

The data flow will follow the MVVM pattern:

1.  **User Interaction:** A user taps a button in the `CalculatorKeypad` composable.
2.  **View to ViewModel:** The composable calls the corresponding function in the `CalculatorViewModel` (e.g., `viewModel.onNumberClick("5")`).
3.  **ViewModel to Model:** The `ViewModel` uses the `CalculatorModel` to perform the necessary logic (e.g., adding the number to the expression, performing a calculation).
4.  **Model to ViewModel:** The `Model` returns the updated state to the `ViewModel`.
5.  **ViewModel to View:** The `ViewModel` updates its state properties. Because the composables are observing the `ViewModel`, the UI automatically recomposes to reflect the new state.