plugins {
    java
    kotlin("jvm") version "1.4.10"
    application
}

group = "by.snb"
version = "0.0.0"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
}

application {
    mainClass.set("by.snb.casino.App")
}
