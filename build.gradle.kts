plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
    id("io.papermc.paperweight.userdev") version "1.6.3"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.2.4"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.rysefoxx"
version = "1.0-SNAPSHOT"
paperweight.reobfArtifactConfiguration = io.papermc.paperweight.userdev.ReobfArtifactConfiguration.MOJANG_PRODUCTION

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/groups/public/") }
}

dependencies {
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:1.20.3")
    implementation("dev.jorel:commandapi-bukkit-shade:9.4.0")
    implementation("dev.jorel:commandapi-bukkit-kotlin:9.4.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.charleskorn.kaml:kaml:0.58.0")

    library(kotlin("stdlib"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "21"
    }

    runServer {
        minecraftVersion("1.20.6")
    }

    shadowJar {
        mergeServiceFiles()
    }
}

paper {
    name = "Challenge"
    apiVersion = "1.20"
    author = "Rysefoxx"
    main = "$group.challenge.Challenge"
    loader = "$group.loader.PluginLoader"
    version = getVersion().toString()
    generateLibrariesJson = true
}