
import Versions.ACTIVITY_COMPOSE_VERSION
import Versions.COMPOSE_MATERIAL_VERSION
import Versions.COMPOSE_UI_VERSION
import Versions.CORE_KTX_VERSION
import Versions.COROUTINES_ANDROID_VERSION
import Versions.COROUTINES_CORE_VERSION
import Versions.ESPRESSO_VERSION
import Versions.JUNT_VERSION
import Versions.KOIN_ANDROID_VERSION
import Versions.KOIN_CORE_VERSION
import Versions.LIFECYCLE_RUNTIME_VERSION
import Versions.TEST_JUNIT_VERSION
import Versions.RETROFIT_VERSION
import Versions.LIFECYCLE_COMPOSE_VERSION
import Versions.COIL_VERSION
import Versions.OKHTTP_VERSION
import Versions.COMPOSE_NAVIGATION_VERSION
import Versions.MOCKK_VERSION

object Depends {
    val core_ktx by lazy { "androidx.core:core-ktx:${CORE_KTX_VERSION}" }
    val lifecycle_runtime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${LIFECYCLE_RUNTIME_VERSION}" }
    val lifecycle_viewmodel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${LIFECYCLE_RUNTIME_VERSION}" }
    val lifecycle_compose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${LIFECYCLE_COMPOSE_VERSION}" }
    val activity_compose by lazy { "androidx.activity:activity-compose:${ACTIVITY_COMPOSE_VERSION}" }
    val compose_ui by lazy { "androidx.compose.ui:ui:${COMPOSE_UI_VERSION}" }
    val compose_ui_tooling_preview by lazy { "androidx.compose.ui:ui-tooling-preview:${COMPOSE_UI_VERSION}" }
    val compose_material by lazy { "androidx.compose.material:material:${COMPOSE_MATERIAL_VERSION}" }
    val junit by lazy { "junit:junit:${JUNT_VERSION}" }
    val test_junit by lazy { "androidx.test.ext:junit:${TEST_JUNIT_VERSION}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${ESPRESSO_VERSION}" }
    val compose_ui_test by lazy { "androidx.compose.ui:ui-test-junit4:$COMPOSE_UI_VERSION" }
    val compose_ui_tooling by lazy { "androidx.compose.ui:ui-tooling:$COMPOSE_UI_VERSION" }
    val compose_ui_manifest by lazy { "androidx.compose.ui:ui-test-manifest:$COMPOSE_UI_VERSION" }
    val compose_navigation by lazy { "androidx.navigation:navigation-compose:$COMPOSE_NAVIGATION_VERSION" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION" }
    val gson by lazy { "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION" }
    val koin_core by lazy { "io.insert-koin:koin-core:$KOIN_CORE_VERSION" }
    val koin_android by lazy { "io.insert-koin:koin-android:$KOIN_CORE_VERSION" }
    val koin_compose by lazy { "io.insert-koin:koin-androidx-compose:$KOIN_ANDROID_VERSION" }
    val coroutines_android by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_ANDROID_VERSION" }
    val coroutines_core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_CORE_VERSION" }
    val coil by lazy { "io.coil-kt:coil-compose:$COIL_VERSION" }
    val okhttp3 by lazy { "com.squareup.okhttp3:logging-interceptor:$OKHTTP_VERSION" }
    val mockk_android by lazy { "io.mockk:mockk-android:$MOCKK_VERSION" }
    val coroutines_test by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:$COROUTINES_ANDROID_VERSION" }
}