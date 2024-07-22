plugins {
    alias(libs.plugins.bootlogger.android.library)
}

android {
    namespace = "com.example.core.ui"
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.androidx.fragment)
    api(libs.androidx.activity)
    api(libs.androidx.constraintlayout)
}