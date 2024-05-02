package io.github.rysefoxx.challenge.config

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.logger.slf4j.ComponentLogger
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class ConfigManager<T : Any>(
    plugin: JavaPlugin,
    id: String,
    private val serializer: KSerializer<T>,
    defaultConfig: T
) {
    private val configFile = File(plugin.dataFolder, "${id.lowercase()}_config.json")

    init {
        if (!configFile.exists()) {
            configFile.parentFile.mkdirs()
            saveConfig(defaultConfig)
        }
    }

    fun loadConfig(): T {
        val json = Json { ignoreUnknownKeys = true }
        val configString = configFile.readText()
        return json.decodeFromString(serializer, configString)
    }

    private fun saveConfig(config: T) {
        try {
            val json = Json { prettyPrint = true; encodeDefaults = true }
            val configString = json.encodeToString(serializer, config)
            configFile.writeText(configString)
        } catch (e: Exception) {
            println("Error saving configuration: ${e.localizedMessage}")
            ComponentLogger.logger().error(Component.text("Error saving configuration: ${e.localizedMessage}"))
        }
    }

}
