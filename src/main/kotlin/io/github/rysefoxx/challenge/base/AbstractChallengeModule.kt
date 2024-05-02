package io.github.rysefoxx.challenge.base

import io.github.rysefoxx.challenge.config.ConfigManager
import kotlinx.serialization.KSerializer
import org.bukkit.plugin.java.JavaPlugin

abstract class AbstractChallengeModule<T : Any>(
    private val plugin: JavaPlugin,
    private val configSerializer: KSerializer<T>,
    private val defaultConfig: T
) {
    abstract val id: String
    abstract val challengeModule: ChallengeModule

    private val configManager by lazy { ConfigManager(plugin, id, configSerializer, defaultConfig) }
    val config by lazy { configManager.loadConfig() }
}
