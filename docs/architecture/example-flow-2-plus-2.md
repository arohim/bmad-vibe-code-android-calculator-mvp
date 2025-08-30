# Example Flow: "2 + 2 = "

1.  User taps "2". The `ViewModel` updates its internal state. The display shows "2".
2.  User taps "+". The `ViewModel` updates its state. The display shows "2 + ".
3.  User taps "2". The `ViewModel` updates its state. The display shows "2 + 2".
4.  User taps "=". The `ViewModel` calls the `CalculatorModel` to compute the result of "2 + 2".
5.  The `CalculatorModel` returns "4". The `ViewModel` updates the main display state to "4" and adds "2 + 2 = 4" to its history state.
6.  The UI updates to show "4" on the main display.