# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is an Android Calculator MVP following story-driven development using the BMad Method framework. The project implements a basic calculator with arithmetic operations using modern Android development patterns.

## Build and Development Commands

### Building the Project
```bash
# Build debug APK (Windows)
gradlew.bat build

# Build debug APK (Unix/Linux)
./gradlew build

# Assemble debug APK
gradlew.bat assembleDebug
```

### Project Structure Commands
```bash
# Generate project structure tree (not available in this project)
# Use Glob tool instead: Glob pattern="**/*.kt" to find Kotlin files
```

## Architecture

### MVVM Pattern Implementation
The project follows strict MVVM (Model-View-ViewModel) architecture:

- **Model Layer** (`com.bmadcalculator.models/`):
  - `CalculatorModel.kt`: Core business logic, calculation engine, expression parsing
  - `Calculation.kt`: Data class for calculation history entries
  
- **ViewModel Layer** (`com.bmadcalculator.viewmodels/`):
  - `CalculatorViewModel.kt`: UI state management with `onNumberClick()`, `onOperatorClick()`, `onEqualsClick()`
  
- **View Layer** (`com.bmadcalculator.ui/`):
  - `CalculatorDisplay.kt`: Monospace display with 12-character limit
  - `CalculatorKeypad.kt`: 4x3 grid with operator buttons
  - `MainActivity.kt`: Single activity with Jetpack Compose setup

### Technology Stack
- **Language**: Kotlin with official code style
- **UI**: Jetpack Compose with Material Design 3
- **State Management**: Reactive `mutableStateOf` patterns
- **Target**: Android 7.0+ (API 24), compiled with SDK 34

### Key Patterns
- Single display architecture (shows both expressions and results)
- Unidirectional data flow: UI → ViewModel → Model → State → UI
- Expression building states: "2" → "2+" → "2+3" → "5" (after equals)
- In-memory calculation history storage for MVP

## Story-Driven Development

### Documentation Structure
- `docs/stories/`: Individual story files with acceptance criteria and QA results
- `docs/prd/`: Sharded Product Requirements Documents
- `docs/architecture/`: Technical architecture specifications

### Story Implementation Process
1. Stories contain detailed Dev Notes with architectural context
2. Implementation follows existing MVVM patterns from previous stories
3. All stories include comprehensive QA verification sections
4. Dev Agent Records document implementation details and file modifications

### Current Implementation Status
- ✅ **Story 1.1**: Basic Calculator UI and Number Input - Complete
- ✅ **Story 1.2**: Addition Operation with History - Complete
- 🎯 **Next**: Story 1.3 - Subtraction Operation Implementation

## Development Guidelines

### Code Conventions
- Follow existing component patterns when extending functionality
- Maintain backward compatibility with previous story implementations
- Preserve 12-character display limit and overflow handling
- Use KDoc comments for public methods
- Follow Material Design 3 theming established in existing components

### State Management
- All UI state flows through ViewModel reactive properties
- Model layer manages business logic and data persistence
- Use `_isWaitingForOperand` flag pattern for expression building
- Display value serves dual purpose: expression building and results

### Component Extensions
When adding new functionality:
- Extend existing components rather than creating new ones
- Follow established callback patterns (`onNumberClick`, `onOperatorClick`, etc.)
- Maintain existing button styling with `isOperator` parameter for differentiation
- Ensure expression parsing handles edge cases with safe defaults

### Testing and Verification
- Stories include comprehensive acceptance criteria validation
- QA sections document complete end-to-end flow verification
- Implementation preserves all existing functionality while adding new features
- Manual testing follows documented example flows (e.g., "2+2=4" flow)

## Testing Commands

### Running Tests
```bash
# Run unit tests
gradlew.bat test

# Run instrumented tests
gradlew.bat connectedAndroidTest
```

## Dependencies and Package Structure

### Core Dependencies (from build.gradle.kts)
- **Jetpack Compose**: UI toolkit with BOM for version alignment
- **Material Design 3**: `androidx.material3` for theming
- **Lifecycle & ViewModel**: `lifecycle-viewmodel-compose` for MVVM
- **Testing**: JUnit, Espresso, and Compose testing libraries

### Package Organization
```
com.bmadcalculator/
├── models/              # Business logic and data classes
│   ├── CalculatorModel.kt
│   └── Calculation.kt
├── viewmodels/          # State management
│   └── CalculatorViewModel.kt
├── ui/                  # Compose UI components
│   ├── CalculatorDisplay.kt
│   ├── CalculatorKeypad.kt
│   └── theme/           # Material Design 3 theming
└── MainActivity.kt      # Single activity entry point
```

## Story-Driven Implementation Notes

### Working with Stories
- Each story in `docs/stories/` contains detailed Dev Notes with architectural context
- Stories reference `docs/architecture/` files for technical specifications
- Always check previous story QA sections for implementation patterns
- Maintain backward compatibility when extending existing components

### Next Story Development
When implementing new calculator operations:
1. Follow the established pattern from Story 1.2 (Addition Operation)
2. Extend `CalculatorModel` calculation engine with new operator support
3. Add operator button to `CalculatorKeypad` with `isOperator = true`
4. Update expression parsing logic while preserving existing functionality
5. Ensure QA testing covers complete operation flow (e.g., "5-3=2")