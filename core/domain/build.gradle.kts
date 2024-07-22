plugins {
    alias(libs.plugins.bootlogger.android.library.domain)
}

android {
    namespace = "com.example.core.domain"
}

dependencies {
    implementation(projects.core.data)
}
