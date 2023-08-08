object Dependencies {

    object AppConfig {
        const val namespace = "com.geektech.testdsl"
        const val compileSdk = 33
        const val applicationId = "com.geektech.testdsl"
        const val minSdk = 21
        const val targetSdk = 33
        const val versionCode = 1
        const val versionName = "1.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object UI {
        const val androidCore = "androidx.core:core-ktx:1.9.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.2"
        const val androidMaterial = "com.google.android.material:material:1.6.1"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val jUnit = "junit:junit:4.13.2"
        const val androidJUnit = "androidx.test.ext:junit:1.1.3"
        const val testEspresso = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object LifeCycle {
        const val lifeCycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
        const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    }

    object Coroutines {
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    }

    object DaggerHilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:2.43"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:2.43"
    }

    object Room {
        private const val version = "2.4.3"
        const val roomRuntime = "androidx.room:room-runtime:$version"
        const val roomCompiler = "androidx.room:room-compiler:$version"
        const val roomKTX = "androidx.room:room-ktx:$version"
    }

    object NavComponent {
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:2.5.2"
        const val navUI = "androidx.navigation:navigation-ui-ktx:2.5.2"
    }

    object Modules {
        const val domain = ":domain"
        const val data = ":data"
    }

    object Plugins {

    }
}