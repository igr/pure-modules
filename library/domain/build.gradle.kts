plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "dev.oblac.library"
version = "0.0.1"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}
