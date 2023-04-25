plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace 'com.example.test0421'
    compileSdk 33

    defaultConfig {
        applicationId "com.example.test0421"
        minSdk 23
        targetSdk 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    /*
    * 컴파일된 코드가
    * */
    kotlinOptions {
        jvmTarget = '1.8'
    }
    buildFeatures {
        compose = true
    }
    /*
    * 'composeOptions' 구성은 Compose을 활성화하고 해당 버전을 지정하는 데 사용된다.
    * 예를들어, Compose 활성화/비활성화, Compose 버전 설정, Kotlin 컴파일러 버전 설정 및 Compose 컴파일러 인수 구성
    * 'kotlilnCompilerExtensionVersion' 구성은 Compose 에서 필요한 Kotlin 컴파일러 확장이 사용 가능한지 확인하는 데 사용된다.
    * 예를들어, 사용할 Kotlin 컴파일러 확장 버전을 지정하고, 코루틴, 직렬화 및 Android 확장 등 Kotline 컴파일러 추가 기능을 제공한다.
    * */
    composeOptions {
        kotlinCompilerExtensionVersion '1.4.2'
    }
    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}

dependencies {

    val appcompat_version = "1.6.1"
    val activity_version = "1.6.1"
    val lifecycle_version = "2.5.1"
    val core_version = "1.10.0"
    val composeBom = platform("androidx.compose:compose-bom:2023.01.00")
    implementation composeBom
    androidTestImplementation composeBom

    // only import the main APIs for the underlying toolkit systems, such as input and measurement/layout
    implementation("androidx.compose.ui:ui")
    // Material Design 3
    implementation("androidx.compose.material3:material3")

    // 앱의 API 레벨 호환성을 해결한다.
    implementation("androidx.appcompat:appcompat:$appcompat_version")
    // For loading and tinting drawables on older versions of the platform
    implementation("androidx.appcompat:appcompat-resources:$appcompat_version")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Kotlin
    implementation("androidx.core:core-ktx:$core_version")

    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    // Optional - Test helpers for Lifecycle runtime
    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")

    // Kotlin
    implementation("androidx.activity:activity-ktx:$activity_version")

//    implementation platform ('androidx.compose:compose-bom:2022.10.00')
//    implementation 'androidx.compose.ui:ui'
//    implementation 'androidx.compose.ui:ui-graphics'
//    implementation 'androidx.compose.ui:ui-tooling-preview'
//    implementation 'androidx.compose.material3:material3'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//    androidTestImplementation platform ('androidx.compose:compose-bom:2022.10.00')
//    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
//    debugImplementation 'androidx.compose.ui:ui-tooling'
//    debugImplementation 'androidx.compose.ui:ui-test-manifest'
}