🚀 Cross-Platform Augmented Reality (AR) Integration with Unity and Kotlin
This repository hosts the Augmented Reality (AR) library built with Unity (AR Foundation) and the host application built with Android/Kotlin (Jetpack Compose), created to test ARCore integration and functionality on mobile devices.

The main goal of this project is to encapsulate an AR feature into a self-contained Unity module, allowing it to be launched on demand from a native host application. The ultimate aim is to transition to React Native for a true cross-platform solution.

🛠️ Technology Stack
Component	Technology	Role
AR Core	Unity 6.2 (URP)	Development of surface detection logic (Plane Detection) and 3D object placement.
AR Framework	AR Foundation 6.x	Abstraction layer enabling the code to function on both ARCore (Android) and ARKit (iOS).
Host App	Kotlin & Jetpack Compose	Modern user interface and the entry point for launching the Unity module.
Integration	Unity Module as Gradle Library	Export method allowing the Unity module to execute within the Kotlin runtime environment.

Exportar para as Planilhas
✨ Implemented Feature
The Unity project currently includes the basic Augmented Reality functionality:

Environmental Tracking: Uses ARCore for 6 Degrees of Freedom (6 DoF) positional tracking and horizontal plane detection.

Object Placement: Allows the user to tap a detected surface (floor, table) to instantiate or move a 3D object (currently a simple Cube).

🏗️ How the Integration Works (Android)
The integration is managed through the Gradle build system, treating the Unity scene as a fully contained, launchable Android Activity:

The Unity project is exported as the unityLibrary folder (a Gradle module).

The main app's AndroidManifest.xml is configured to declare the UnityPlayerGameActivity.

The Kotlin/Compose code initiates the AR experience using an explicit Intent directed at the UnityPlayerGameActivity.

Module Structure
:app (Kotlin/Compose): Contains the MainActivity and the UI button logic.

:unityLibrary (Unity): Contains the compiled C# logic, assets, and native binaries.

👨‍💻 Setup and Installation (For Contributors)
To set up and run this project in your local environment:

Clone the Repository:

Bash

git clone https://github.com/cardosoalana/RA-Unit-Project.git
cd ARProject
Open in Android Studio: Open the ARProject folder in Android Studio (version 2023.x or later).

Unity Environment: Ensure you have Unity Editor 6.2 with the Android and iOS modules installed.

Native Cache Check: If you encounter UnsatisfiedLinkError errors, run a cleanup in the terminal:

Bash

./gradlew clean
Build and Run: Compile and deploy the application to your physical Android device (API 24+ required) that supports ARCore.
