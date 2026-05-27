# Navigation3 Training Project

An Android application built to explore and implement **Jetpack Navigation 3**, the next-generation type-safe navigation library for Jetpack Compose.

## 🚀 Overview
This project serves as a practical implementation of the latest Android development practices, specifically focusing on the new **Navigation 3** APIs. It demonstrates how to handle type-safe routing, ViewModel scoping, and state preservation in a modern Compose environment.

## 🛠 Tech Stack
- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Navigation:** [Navigation 3](https://developer.android.com/jetpack/androidx/releases/navigation) (androidx.navigation3)
- **State Management:** [Architecture Components ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- **Serialization:** [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization) for type-safe routes.
- **Dependency Management:** Version Catalog (`libs.versions.toml`)

## ✨ Key Features
- **Type-Safe Routing:** Implementation of `NavKey` and sealed interfaces for robust navigation without string-based routes.
- **Navigation 3 Integration:** Showcases `NavDisplay`, `rememberNavBackStack`, and `entryProvider`.
- **ViewModel Scoping:** Uses `rememberViewModelStoreNavEntryDecorator` to ensure ViewModels are scoped correctly to the navigation backstack.
- **Shared State:** Example of `SharedAuthViewModel` for state sharing between authentication screens.
- **Material 3:** Modern UI components and theming.

## 📁 Project Structure
- `ui/navigation/`: Navigation root, backstack configuration, and route definitions.
- `ui/screens/`: Feature-specific Compose screens (Todo List, Detail, Auth).
- `ui/viewmodels/`: Business logic and state handling using ViewModels.

---
*Note: This project is currently configured specifically for **Android** development.*
