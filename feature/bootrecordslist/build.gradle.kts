plugins {
    alias(libs.plugins.bootlogger.android.feature)
}

android {
    namespace = "com.example.feature.bootrecordslist"
}

dependencies {
    implementation(projects.core.domain)
}