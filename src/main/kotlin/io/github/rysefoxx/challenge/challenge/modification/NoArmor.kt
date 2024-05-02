package io.github.rysefoxx.challenge.challenge.modification

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent
import io.github.rysefoxx.challenge.base.AbstractChallengeModule
import io.github.rysefoxx.challenge.base.ChallengeModule
import io.github.rysefoxx.challenge.config.impl.NoArmorConfig
import io.github.rysefoxx.challenge.extension.subtractMaxHealth
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.onlinePlayers
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin


class NoArmor(plugin: JavaPlugin) : AbstractChallengeModule<NoArmorConfig>(
    plugin,
    NoArmorConfig.serializer(),
    NoArmorConfig()
) {

    override val id: String = "no_armor"
    override val challengeModule: ChallengeModule = ChallengeModule.MODIFICATION

    private val isEnabled: Boolean = config.isEnabled
    private val damage: Double = config.damage
    private val permanent: Boolean = config.permanent
    private val sharedDamage: Boolean = config.sharedDamage

    val armorChanged = listen<PlayerArmorChangeEvent> {
        if (!isEnabled) return@listen
        if (damage == 0.0) return@listen

        if (sharedDamage) return@listen damageAllPlayers()
        damage(it.player)
    }

    private fun damageAllPlayers() {
        onlinePlayers.forEach { player ->
            damage(player)
        }
    }

    private fun damage(player: Player) {
        if (permanent) return player.subtractMaxHealth(damage * 2)
        player.damage(damage * 2)
    }
}