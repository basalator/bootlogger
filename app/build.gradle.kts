plugins {
    alias(libs.plugins.bootlogger.android.application)
    alias(libs.plugins.bootlogger.android.application.flavors)
    alias(libs.plugins.bootlogger.android.hilt)
}

android {
    namespace = "com.example.bootlogger"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bootlogger"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    
    implementation(projects.feature.bootrecordslist)
    implementation(projects.feature.bootworker)

    implementation(projects.core.ui)
    implementation(libs.timber)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
