```architecture.md```
### **Frontend Architecture for Android Calculator MVP**

#### **1. Technology Stack**

* **Programming Language:** Kotlin. This is the recommended language for modern Android development, providing concise and expressive code.
* **UI Framework:** Jetpack Compose. This is Android's modern toolkit for building native UI, offering a declarative approach that simplifies UI development and state management.
* **Architecture Pattern:** MVVM (Model-View-ViewModel). This pattern promotes separation of concerns, making the code more modular, testable, and maintainable.
    * **View:** The UI components (composables) that the user interacts with. They observe changes in the ViewModel.
    * **ViewModel:** Holds and manages UI-related data. It survives configuration changes (e.g., screen rotation) and interacts with the Model.
    * **Model:** The data layer, which handles business logic and data manipulation (e.g., performing calculations, managing history).

#### **2. Component Breakdown**

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

#### **3. Data Flow**

The data flow will follow the MVVM pattern:

1.  **User Interaction:** A user taps a button in the `CalculatorKeypad` composable.
2.  **View to ViewModel:** The composable calls the corresponding function in the `CalculatorViewModel` (e.g., `viewModel.onNumberClick("5")`).
3.  **ViewModel to Model:** The `ViewModel` uses the `CalculatorModel` to perform the necessary logic (e.g., adding the number to the expression, performing a calculation).
4.  **Model to ViewModel:** The `Model` returns the updated state to the `ViewModel`.
5.  **ViewModel to View:** The `ViewModel` updates its state properties. Because the composables are observing the `ViewModel`, the UI automatically recomposes to reflect the new state.

#### **4. Example Flow: "2 + 2 = "**

1.  User taps "2". The `ViewModel` updates its internal state. The display shows "2".
2.  User taps "+". The `ViewModel` updates its state. The display shows "2 + ".
3.  User taps "2". The `ViewModel` updates its state. The display shows "2 + 2".
4.  User taps "=". The `ViewModel` calls the `CalculatorModel` to compute the result of "2 + 2".
5.  The `CalculatorModel` returns "4". The `ViewModel` updates the main display state to "4" and adds "2 + 2 = 4" to its history state.
6.  The UI updates to show "4" on the main display.