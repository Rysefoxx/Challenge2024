package io.github.rysefoxx.challenge.extension

import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player


fun Player.subtractMaxHealth(subtract: Double) {
    val attribute = player?.getAttribute(Attribute.GENERIC_MAX_HEALTH) ?: return
    val maxHealth = attribute.baseValue
    val newMaxHealth = maxHealth - subtract

    attribute.baseValue = newMaxHealth
}