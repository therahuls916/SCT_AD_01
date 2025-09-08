# ✅ Auric Calculator - A Modern Android Calculator
### A comprehensive Android project showcasing modern development practices for SkillCraft Technology.

Auric Calculator is a sleek, powerful, and modern calculator application for Android, built entirely with Kotlin and Jetpack Compose. It provides a clean, intuitive user interface that supports complex mathematical expressions with a live-updating dual display. The app correctly handles the order of operations (BODMAS/PEMDAS) and is designed with a robust MVVM architecture, ensuring a scalable and maintainable codebase.

---
---
## 📸 Screenshots

| Main Screen (Calculation) | Dark Theme (Default) |
| :---: |:---:|
| *(Your Screenshot Here)* | *(Your Screenshot Here)* |
| A screenshot showing a complex calculation like `8+12/(6-2)` with the live result `11` displayed below. | A screenshot showing the default dark theme of the calculator, ready for input. |

---

## 🚀 Features

| Feature | Description |
|---|---|
| ✅ **BODMAS/PEMDAS Accuracy** | Correctly evaluates complex mathematical expressions using the standard order of operations. It's not just a simple left-to-right calculator. |
| ✨ **Modern UI/UX** | Built entirely with **Jetpack Compose & Material 3** components. Features a clean, professional, dark-themed UI that is highly readable. |
| 🔢 **Dual Display** | Shows the full mathematical **expression** as you type, with the **live result** calculated and displayed underneath in real-time. |
| 🎛️ **Full Functionality** | Includes all standard functions: **C**lear, **( )** Parentheses, **%** Percentage, **⌫** Backspace, and **+/-** Negate. |
| 💾 **State Persistence** | The calculator's state is automatically saved and restored during configuration changes (like screen rotation) thanks to the `ViewModel`. |
| 🏗️ **Robust Architecture** | Built on a modern **MVVM** foundation with a reactive data flow using Kotlin `StateFlow`, ensuring a clean separation between UI and logic. |

---

## 🔧 Installation

1.  Clone the repository:
    ```bash
    git clone https://github.com/therahuls916/SCT_AD_01.git
    ```
2.  Navigate to the project directory:
    ```bash
    cd SCT_AD_01
    ```
3.  Open the project in the latest stable version of Android Studio, let Gradle sync, and click ▶️ **Run**.

## 🛠 Tech Stack

-   **Tech:** Kotlin
-   **Architecture:** MVVM (Model-View-ViewModel)
-   **UI:** Jetpack Compose, Material 3
-   **Math Engine:**
    -   [MathParser.org-mXparser](https://mathparser.org/): A powerful, open-source library for parsing and evaluating mathematical expressions accurately.
-   **State Management:**
    -   ViewModel with StateFlow

---
---
## 📂 Folder Structure
```plaintext
app/src/main/java/com/rahul/auric/calculator/
├── ui/
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Theme.kt
│   │   └── Type.kt
├── CalculatorAction.kt      # Sealed class of all possible user actions (Number, Operation, etc.)
├── CalculatorButton.kt      # Reusable Composable for every button on the keypad
├── CalculatorScreen.kt      # Main UI screen with the display and button layout
├── CalculatorState.kt       # Data class representing the screen's state (expression, result)
├── CalculatorViewModel.kt   # ViewModel to hold state and business logic
└── MainActivity.kt          # Main entry point for the application
```
---
## 🔐 Permissions Used

This application currently requires **no special permissions**, providing a secure and privacy-focused user experience.

---

## 🧠 How It Works

-   **UI Layer (`CalculatorScreen.kt`):** The entire UI is built with Jetpack Compose. `CalculatorScreen` is the main Composable, which contains the dual display and the button grid. It observes the `StateFlow` from the `TaskViewModel` and reactively recomposes whenever the state (expression or result) changes.
-   **State Management (`CalculatorViewModel.kt`):** The `CalculatorViewModel` holds the application state (`CalculatorState`) in a `StateFlow`. It exposes a single `onAction` method to the UI. Based on the user's action (e.g., `CalculatorAction.Number("7")`), it modifies the `expression` string and triggers a recalculation.
-   **Logic Layer (`mxparser`):** The ViewModel does not perform the math itself. It delegates the complex work to the `mxparser` library. The current `expression` string is passed to the library, which correctly parses it using **BODMAS** rules and returns the final result. This ensures accuracy and separates the calculation logic from the state management logic.

---

## ✅ Planned Features

-   [ ] 📜 **Calculation History:** Add a screen or a slide-up panel to view recent calculations.
-   [ ] 🎨 **Theme Switching:** Add an option to switch between a Light and Dark theme.
-   [ ] 🧪 **Unit Tests:** Write comprehensive JUnit tests for the `CalculatorViewModel` to verify all logic paths.
-   [ ] ✨ **UI Animations:** Add subtle animations for button presses and result updates to enhance the user experience.
-   [ ] 🌐 **Landscape Mode:** Add a scientific calculator layout that appears when the device is rotated.

---

## 🤝 Contributing

Contributions are welcome! If you'd like to help, please fork the repository, create a new branch for your feature or fix, and submit a pull request.

---

## 📄 License

This project is licensed under the MIT License - see the `LICENSE` file for details.

---

## 👨‍💻 Developer

**Rahul Salunke**  
[GitHub](https://github.com/therahuls916)  
[LinkedIn](https://www.linkedin.com/in/rahulasalunke/)