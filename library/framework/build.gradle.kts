plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("commons.android-library")
    kotlin("kapt")
}

android{
    namespace = "com.fitness.framework"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = config.Configs.KotlinCompilerExtensionVersion
    }
}

dependencies {
    addNetworkDependencies()
    addNavigationDependencies()
    addJetpackComposeDependencies()
    addCoroutineDependencies()
    addFirebaseDependencies()
    addMedia3Dependencies()
    RESOURCES
}