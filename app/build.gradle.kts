plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = Dependencies.AppConfig.namespace
    compileSdk = Dependencies.AppConfig.compileSdk

    defaultConfig {
        applicationId = Dependencies.AppConfig.applicationId
        minSdk = Dependencies.AppConfig.minSdk
        targetSdk = Dependencies.AppConfig.targetSdk
        versionCode = Dependencies.AppConfig.versionCode
        versionName = Dependencies.AppConfig.versionName

        testInstrumentationRunner = Dependencies.AppConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation (Dependencies.UI.androidCore)
    implementation (Dependencies.UI.appCompat)
    implementation (Dependencies.UI.androidMaterial)
    implementation (Dependencies.UI.constraint)
    testImplementation (Dependencies.UI.jUnit)
    androidTestImplementation (Dependencies.UI.androidJUnit)
    androidTestImplementation (Dependencies.UI.testEspresso)

    // Lifecycle
    implementation (Dependencies.LifeCycle.lifeCycleLiveData)
    implementation (Dependencies.LifeCycle.lifeCycleViewModel)

    // Coroutines
    implementation (Dependencies.Coroutines.kotlinCoroutines)

    //Room
    implementation(Dependencies.Room.roomRuntime)
    annotationProcessor(Dependencies.Room.roomCompiler)
    implementation (Dependencies.Room.roomKTX)

    // To use Kotlin annotation processing tool (kapt)
    kapt(Dependencies.Room.roomCompiler)

    //Dagger - Hilt
    implementation (Dependencies.DaggerHilt.hiltAndroid)
    kapt (Dependencies.DaggerHilt.hiltCompiler)

    //NavComponent
    implementation(Dependencies.NavComponent.navFragment)
    implementation(Dependencies.NavComponent.navUI)

}