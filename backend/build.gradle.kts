plugins {
    java
    kotlin("jvm") version "1.4.10"
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    application
    id("org.liquibase.gradle") version "2.0.3" // https://github.com/liquibase/liquibase-gradle-plugin
}

group = "by.snb"
version = "0.0.0"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.liquibase:liquibase-core")
    implementation("org.postgresql:postgresql:42.2.19")

    testImplementation("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
}

application {
    mainClass.set("by.snb.casino.App")
}
