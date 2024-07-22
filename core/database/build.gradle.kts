plugins {
    alias(libs.plugins.bootlogger.android.library)
    alias(libs.plugins.bootlogger.android.hilt)
}

android {
    namespace = "com.example.core.database"
}

dependencies {
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
}