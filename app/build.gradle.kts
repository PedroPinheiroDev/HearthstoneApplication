plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Config.NAMESPACE
    compileSdk = Config.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK_VERSION
        applicationId = Config.APPLICATION_ID
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

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
    implementation(project(":designsystem"))
    implementation(project(":onboarding"))

    Depends.run {
        core_ktx.let(::implementation)
        lifecycle_runtime.let(::implementation)
        activity_compose.let(::implementation)
        compose_ui.let(::implementation)
        compose_ui_tooling_preview.let(::implementation)
        compose_material.let(::implementation)
        junit.let(::testImplementation)
        test_junit.let(::androidTestImplementation)
        espresso.let(::androidTestImplementation)
        compose_ui_test.let(::androidTestImplementation)
        compose_ui_tooling.let(::debugImplementation)
        compose_ui_manifest.let(::debugImplementation)
    }
}