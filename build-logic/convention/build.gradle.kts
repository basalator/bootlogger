import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.google.samples.apps.nowinandroid.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "bootlogger.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "bootlogger.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryData") {
            id = "bootlogger.android.library.data"
            implementationClass = "AndroidLibraryDataConventionPlugin"
        }
        register("androidLibraryDomain") {
            id = "bootlogger.android.library.domain"
            implementationClass = "AndroidLibraryDomainConventionPlugin"
        }

        register("androidFeature") {
            id = "bootlogger.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }


        register("androidHilt") {
            id = "bootlogger.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidFlavors") {
            id = "bootlogger.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidTest") {
            id = "bootlogger.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
    }
}
