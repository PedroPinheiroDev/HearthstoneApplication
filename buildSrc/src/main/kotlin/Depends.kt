import Versions.ACTIVITY_COMPOSE_VERSION
import Versions.COMPOSE_MATERIAL_VERSION
import Versions.COMPOSE_UI_VERSION
import Versions.CORE_KTX_VERSION
import Versions.ESPRESSO_VERSION
import Versions.JUNT_VERSION
import Versions.LIFECYCLE_RUNTIME_VERSION
import Versions.TEST_JUNIT_VERSION

object Depends {
    val core_ktx by lazy { "androidx.core:core-ktx:${CORE_KTX_VERSION}" }
    val lifecycle_runtime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${LIFECYCLE_RUNTIME_VERSION}" }
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
}