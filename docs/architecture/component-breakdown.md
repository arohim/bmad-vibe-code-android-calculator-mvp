# Component Breakdown

The application will be structured into the following key components:

* `MainActivity` **(View):** The single activity that hosts the main UI. It will observe the `CalculatorViewModel`.
* `CalculatorViewModel` **(ViewModel):** Manages the state of the calculator. It will contain properties for the current display value, the input expression, and the calculation history. It will expose functions for button clicks (e.g., `onNumberClick()`, `onOperatorClick()`, `onEqualsClick()`) that update its state.
* `CalculatorModel` **(Model):** This class will contain the core business logic.
    * **Calculation Engine:** A component to parse the input expression and compute the result. This will handle the order of operations for the basic arithmetic.
    * **History Manager:** A component to store and retrieve the last 10 calculations. This can be a simple in-memory list for the MVP.
* **UI Composables (View):** Individual UI components built with Jetpack Compose.
    * `CalculatorDisplay`: A composable that shows the main and input display.
    * `CalculatorKeypad`: A composable that contains all the button components for numbers and operators.
    * `HistoryScreen`: A composable that displays the list of past calculations.
* **Data Classes:** Simple data structures to represent the calculation history entries (e.g., `Calculation(expression: String, result: String)`).