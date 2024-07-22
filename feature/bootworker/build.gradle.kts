plugins {
    alias(libs.plugins.bootlogger.android.feature)
}

android {
    namespace = "com.example.feature.bootworker"
}

dependencies {
    implementation(projects.core.domain)
    implementation(libs.androidx.work.ktx)
}