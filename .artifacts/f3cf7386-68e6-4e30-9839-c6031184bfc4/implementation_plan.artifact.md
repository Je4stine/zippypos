# Implementation Plan - Fix `EvalIssueException: Using kotlin.sourceSets DSL to add Kotlin sources is not allowed with built-in Kotlin`

The project is encountering a build error because the `kotlin.sourceSets` DSL is being used (likely implicitly by the KSP plugin) while the new "built-in Kotlin" support in Android Gradle Plugin (AGP) 9.3.1 is active. AGP 9.3+ restricts the use of this DSL for adding sources, favoring the `android.sourceSets` DSL.

## Proposed Changes

### [Component Name] Build Configuration

#### [MODIFY] [gradle.properties](file:///Users/a/AndroidStudioProjects/ZippyPOS/gradle.properties)
- Add `android.disallowKotlinSourceSets=false` to suppress the error and allow the use of `kotlin.sourceSets` DSL. This is a recommended workaround when using plugins (like KSP) that haven't yet migrated to the new source set management in AGP.

## Verification Plan

### Automated Tests
- Run `./gradlew assembleDebug` to verify that the project builds successfully without the `EvalIssueException`.
