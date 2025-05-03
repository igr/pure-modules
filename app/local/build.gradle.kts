plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "dev.oblac.app"
version = "0.0.1"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library:domain"))
    implementation(project(":library:app:mem"))
    implementation(project(":messenger:domain"))

    // you can change the implementation of the messenger app
//    implementation(project(":messenger:app:cli"))
    implementation(project(":messenger:app:http"))
}
