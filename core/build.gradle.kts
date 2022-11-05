plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.pedro.core"
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

        getByName("debug") {
            buildConfigField("String", "KEY", "\"X-RapidAPI-Key\"")
            buildConfigField(
                "String",
                "KEY_VALUE",
                "\"b7c737731bmsh5ed2c0a3cfa12aap16f360jsn117616299d3e\""
            )
            buildConfigField("String", "HOST", "\"X-RapidAPI-Host\"")
            buildConfigField("String", "HOST_VALUE", "\"omgvamp-hearthstone-v1.p.rapidapi.com\"")
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
    Depends.run {
        retrofit.let(::api)
        coil.let(::api)
        okhttp3.let(::api)
        lifecycle_viewmodel.let(::api)
        lifecycle_runtime.let(::api)
        lifecycle_compose.let(::api)
        gson.let(::api)
        koin_core.let(::api)
        koin_android.let(::api)
        koin_compose.let(::api)
        coroutines_android.let(::api)
        coroutines_core.let(::api)
        junit.let(::testImplementation)
        test_junit.let(::androidTestImplementation)
    }
}