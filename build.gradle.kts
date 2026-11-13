plugins {
    `java-library`
    `maven-publish`
}

group = "net.myskl"
version = providers.environmentVariable("TAG_NAME")
    .map { it.removePrefix("v") }
    .getOrElse("1.0-SNAPSHOT")

java {
    toolchain { languageVersion = JavaLanguageVersion.of(25) }
    withSourcesJar()     // ≈ maven-source-plugin
    withJavadocJar()     // ≈ maven-javadoc-plugin
}

dependencies {
    implementation(libs.slf4j.api)
    runtimeOnly(libs.logback.classic)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.launcher)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}