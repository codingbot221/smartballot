// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}

/*buildscript {
    repositories {
        google() // Check if this line is present
        mavenCentral()
    }
    dependencies {
        // Add this line
        classpath 'com.google.gms:google-services:4.3.15' // Use the latest version
    }
}

allprojects {
    repositories {
        google() // Ensure this is here
        mavenCentral()
    }
}*/
