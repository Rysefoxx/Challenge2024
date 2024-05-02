package io.github.rysefoxx.challenge

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import io.github.rysefoxx.challenge.challenge.modification.NoArmor
import net.axay.kspigot.main.KSpigot

class Challenge : KSpigot() {

    override fun load() {
        CommandAPI.onLoad(CommandAPIBukkitConfig(this).silentLogs(true))
    }

    override fun startup() {
        CommandAPI.onEnable()
        NoArmor(this)
    }

    override fun shutdown() {
        CommandAPI.onDisable()
    }
}