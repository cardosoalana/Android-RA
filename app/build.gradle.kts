plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.arproject"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.arproject"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ndk {
            abiFilters.addAll(listOf("arm64-v8a"))
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }
}

dependencies {
    implementation(project(":unityLibrary"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.androidx.games.activity)
    implementation("androidx.core:core-ktx:1.17.0")
    implementation(kotlin("stdlib-jdk8"))
}

afterEvaluate {
    // 1. Encontra a tarefa de fusão de bibliotecas nativas para o build de Debug
    project.tasks.named("mergeDebugJniLibFolders") {
        // 2. Declara que esta tarefa depende da compilação IL2CPP da Unity
        //    Isso garante que o código C# nativo do Unity seja compilado ANTES
        //    de tentarmos empacotar as libs no seu app.
        dependsOn(":unityLibrary:buildIl2Cpp")
    }

    // (Opcional, mas recomendado para o build de Release)
    project.tasks.named("mergeReleaseJniLibFolders") {
        dependsOn(":unityLibrary:buildIl2Cpp")
    }
}