package gg.flyte.smp.util

import gg.flyte.twilight.scheduler.async
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Location
import org.bukkit.entity.Player
import kotlin.random.Random

fun randomTeleport(player: Player) {
    async {
        var foundSafe = false
        val random = Random

        player.sendMessage(Component.text("Teleporting to a random location...").color(NamedTextColor.GREEN))

        while (!foundSafe) {
            val x = random.nextInt(1024)
            val z = random.nextInt(1024)

            val highestBlock = player.world.getHighestBlockAt(x, z)

            if (!highestBlock.isEmpty && highestBlock.isSolid) {
                player.teleportAsync(
                    Location(
                        player.world,
                        x.toDouble(),
                        highestBlock.y.toDouble() + 1,
                        z.toDouble()
                    )
                )

                player.sendMessage(Component.text("Teleported you to X: $x, Z: $z").color(NamedTextColor.GREEN))
                foundSafe = true
            }
        }
    }
}