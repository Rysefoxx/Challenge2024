package io.github.rysefoxx.challenge.config.impl

import kotlinx.serialization.Serializable

@Serializable
data class NoArmorConfig(
    val isEnabled: Boolean = false,
    val damage: Double = 1.0,
    val permanent: Boolean = false,
    val sharedDamage: Boolean = false
)
