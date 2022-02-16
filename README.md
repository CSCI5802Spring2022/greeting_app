# Description

This is the Greeting app used in CSCI 5802.

# Setup

* Import the app in Android Studio
* Create an emulator
* Start emulator

# Testing Commands

The following commands can be run from the command-line interface inside Android Studio.

* Run unit tests
    * `./gradlew clean testDebugUnitTest`
* Run GUI tests
    * `./gradlew clean connectedDebugAndroidTest`
* Run acceptance tests
    * `./gradlew clean -Pcucumber connectedDebugAndroidTest`