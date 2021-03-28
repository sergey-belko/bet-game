import com.github.gradle.node.yarn.task.YarnTask

plugins {
    id("com.github.node-gradle.node") version "3.0.1"
}

defaultTasks("build", "test", " clean")

tasks.register<Delete>("clean") {
    delete("build")
}

tasks.register<YarnTask>("yarn-start") {
    group = "casino-yarn"
    args.set(listOf("start"))
}

tasks.register<YarnTask>("install") {
    group = "casino-yarn"
    args.set(listOf("install"))
}

tasks.register<YarnTask>("build") {
    group = "casino-yarn"
    args.set(listOf("build"))

    dependsOn("install")
}

tasks.register<YarnTask>("test") {
    group = "casino-yarn"
    args.set(listOf("test"))
}