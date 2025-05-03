plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "dev.oblac.messenger"
version = "0.0.1"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}
