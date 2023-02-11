plugins {
    alias(libs.plugins.runwaterfall)
    alias(libs.plugins.pluginyml.bungee)
}

dependencies {
    implementation(projects.core)

    compileOnly(libs.adventure.platform.bungeecord)
    compileOnly(libs.waterfall)
}

tasks {
    build {
        dependsOn(shadowJar)
    }
    runWaterfall {
        waterfallVersion(libs.versions.waterfall.get().substringBefore('-'))
    }
}

bungee {
    main = "me.xneox.epicguard.waterfall.EpicGuardWaterfall"
    description = project.description as String
    name = "EpicGuard"
    version = project.version as String
    author = "neox, 4drian3d"
    libraries = listOf(
        "${libs.adventure.platform.bungeecord.get().module}:${libs.versions.adventure.platform.get()}",
        "${libs.sqlite.get().module}:${libs.versions.sqlite.get()}"
    )
}
