import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.10"
    id("gg.jte.gradle") version("3.2.1-SNAPSHOT")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    implementation("gg.jte:jte-runtime:3.2.1-SNAPSHOT")
}

jte {
    generate()
}

tasks.test {
    useJUnitPlatform()
}

// See docs here:
// https://docs.gradle.org/8.0.1/userguide/toolchains.html#sec:consuming
// According to Kotlin Gradle Plugin docs:
// https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
// > You can set a toolchain via the java extension, and Kotlin compilation tasks will use it
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
