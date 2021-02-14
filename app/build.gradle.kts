plugins {
    kotlin("jvm").version("1.4.30")
}

repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/skija/maven")
}
dependencies {
    implementation("org.jetbrains.skija:skija-linux:0.89.18")
}
