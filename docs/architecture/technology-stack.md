# Technology Stack

* **Programming Language:** Kotlin. This is the recommended language for modern Android development, providing concise and expressive code.
* **UI Framework:** Jetpack Compose. This is Android's modern toolkit for building native UI, offering a declarative approach that simplifies UI development and state management.
* **Architecture Pattern:** MVVM (Model-View-ViewModel). This pattern promotes separation of concerns, making the code more modular, testable, and maintainable.
    * **View:** The UI components (composables) that the user interacts with. They observe changes in the ViewModel.
    * **ViewModel:** Holds and manages UI-related data. It survives configuration changes (e.g., screen rotation) and interacts with the Model.
    * **Model:** The data layer, which handles business logic and data manipulation (e.g., performing calculations, managing history).