package io.github.rysefoxx.challenge.extension

import net.axay.kspigot.chat.KColors
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

val cBase = NamedTextColor.GRAY
val cSecondary = NamedTextColor.DARK_GRAY
val cHighlight = TextColor.color(0xD2A1F2)
val cError = KColors.INDIANRED

operator fun Component.plus(other: Component) = append(other)
fun cmp(text: String, color: TextColor = cBase) = Component.text(text, color)
fun secondary(text: String) = cmp(text, cSecondary)
fun highlight(text: String) = cmp(text, cHighlight)
fun err(text: String) = cmp(text, cError)
fun prefix() = secondary("| ") + highlight("Challenge") + secondary(" » ")