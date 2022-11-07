plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.pedro.cards_details"
    compileSdk = Config.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = Config.MIN_SDK_VERSION

        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Config.JVM_TARGET
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.KOTLIN_COMPILER_EXTENSION_VERSION
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":designsystem"))

    Depends.run {
        compose_ui.let(::implementation)
        compose_ui_tooling_preview.let(::implementation)
        compose_material.let(::implementation)
        retrofit.let(::implementation)
        junit.let(::testImplementation)
        mockk_android.let(::testImplementation)
        coroutines_test.let(::testImplementation)
        test_junit.let(::androidTestImplementation)
    }
}