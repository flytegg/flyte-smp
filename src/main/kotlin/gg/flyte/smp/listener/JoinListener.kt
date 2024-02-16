package gg.flyte.smp.listener

import gg.flyte.twilight.event.event
import gg.flyte.twilight.scheduler.async
import gg.flyte.twilight.scheduler.delay
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Location
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import kotlin.random.Random

class JoinListener : Listener {

    init {
        event<PlayerJoinEvent> {
            delay {
                async {
                    if(!player.hasPlayedBefore()) {
                        var foundSafe = false
                        val random = Random.Default

                        player.sendMessage(Component.text("Finding you a safe location...").color(NamedTextColor.GREEN))

                        while(!foundSafe) {
                            val x = random.nextInt(1024)
                            val z = random.nextInt(1024)

                            val highestBlock = player.world.getHighestBlockAt(x, z)

                            if(!highestBlock.isEmpty && highestBlock.isSolid) {
                                player.teleportAsync(Location(player.world, x.toDouble(), highestBlock.y.toDouble(), z.toDouble()))
                                player.sendMessage(Component.text("Teleported you to X: $x, Z: $z").color(NamedTextColor.GREEN))
                                foundSafe = true
                            }
                        }
                    }
                }
            }
        }
        
    }

}