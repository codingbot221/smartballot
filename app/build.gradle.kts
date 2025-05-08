plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.bootcamp1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bootcamp1"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    //implementation(libs.firebase.auth)
    //implementation(libs.firebase.database)
    //implementation(libs.firebase.auth)
    //implementation(libs.firebase.auth)
    //implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}


/*apply plugin: 'com.android.application'
// Add this at the end
apply plugin: 'com.google.gms.google-services'

android {
    ...
}

dependencies {
    // Add Firebase SDKs (the ones you need, such as Analytics)
    implementation platform('com.google.firebase:firebase-bom:32.1.1') // Use the latest BOM version
    implementation 'com.google.firebase:firebase-analytics' // Example Firebase SDK
}
*/

/*plugins {
    alias(libs.plugins.google.gms.google.services)
    id 'com.android.application'
    id 'com.google.gms.google-services'
}

android {
    namespace = "com.example.bootcamp1"
    compileSdkVersion 34

    defaultConfig {
        applicationId "com.example.bootcamp1"
        minSdkVersion 24
        targetSdkVersion 34
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
                targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.play.services.measurement.api)
    implementation(libs.firebase.auth)
    // AndroidX and Material Libraries
    //implementation 'androidx.appcompat:appcompat:1.6.1'
    //implementation 'com.google.android.material:material:1.9.0'
    //implementation 'androidx.activity:activity-ktx:1.7.2'
    //implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    // Firebase Authentication Library
    //implementation 'com.google.firebase:firebase-auth:22.1.1'
    implementation 'com.google.firebase:firebase-analytics:22.1.2'

    // Testing libraries
    //testImplementation 'junit:junit:4.13.2'
   // androidTestImplementation 'androidx.test.ext:junit:1.1.5'
   // androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}*/

