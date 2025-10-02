# 🚀 Cross-Platform Augmented Reality (AR) Integration with Unity and Kotlin

This repository contains an Augmented Reality (AR) library built using **Unity (AR Foundation)** and a native host app built with **Kotlin + Jetpack Compose**. The main goal is to encapsulate AR functionality into a self-contained Unity module, enabling it to be triggered on demand from a native Android application.


## 🛠️ Technology Stack

| Component         | Technology                 | Role                                                                 |
|------------------|----------------------------|----------------------------------------------------------------------|
| **AR Engine**     | Unity 6.2 (URP)             | Handles surface detection and 3D object placement                   |
| **AR Framework**  | AR Foundation 6.x           | Abstraction for ARCore (Android) and ARKit (iOS) support            |
| **Host App**      | Kotlin + Jetpack Compose    | Modern UI and entry point for launching the Unity module            |
| **Integration**   | Unity Library via Gradle    | Exported Unity module run as part of Android app using Intents      |

---

## ✨ Features Implemented

- **🔍 Environmental Tracking**  
  Uses ARCore for positional tracking with 6 Degrees of Freedom (6DoF) and horizontal plane detection.

- **📦 Object Placement**  
  Users can tap on detected surfaces (e.g., floor, table) to place or move a 3D object (currently a simple cube).

---

## 🧩 Project Structure

ARProject/
├── app/ # Native Android app (Jetpack Compose)
│ └── MainActivity.kt
├── unityLibrary/ # Unity exported module (Gradle)
│ └── UnityPlayerGameActivity.java
├── build.gradle # Project-level Gradle config
├── settings.gradle # Includes both modules
└── README.md

yaml
Copiar código

- **:app**  
  Contains the main Kotlin UI logic and button to launch AR experience.

- **:unityLibrary**  
  Contains compiled Unity logic, C# scripts, assets, and native binaries.

---

## 🏗️ How the Integration Works (Android)

1. The Unity project is exported as a Gradle module (`unityLibrary`).
2. The Android host app declares the Unity activity (`UnityPlayerGameActivity`) in the `AndroidManifest.xml`.
3. The Kotlin app launches the Unity activity via an explicit `Intent`.

---

## 👨‍💻 Setup & Installation (For Contributors)

### 1. Clone the Repository

```bash
git clone https://github.com/cardosoalan
