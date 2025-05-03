plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "dev.oblac.messenger.app"
version = "0.0.1"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":messenger:domain"))
}
