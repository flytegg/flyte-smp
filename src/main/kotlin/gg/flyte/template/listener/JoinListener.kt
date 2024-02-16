package gg.flyte.template.listener

import gg.flyte.twilight.event.event
import gg.flyte.twilight.scheduler.delay
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import kotlin.random.Random

class JoinListener : Listener {

    init {
        event<PlayerJoinEvent> {
            delay {
                if(!player.hasPlayedBefore()) {
                    var foundSafe = false
                    val random = Random.Default

                    player.sendMessage(Component.text("Finding you a safe location...").color(NamedTextColor.GREEN))

                    while(!foundSafe) {
                        val x = random.nextInt(1024)
                        val z = random.nextInt(1024)

                        val highestBlock = player.world.getHighestBlockAt(x, z)

                        if(!highestBlock.isEmpty && highestBlock.isSolid) {
                            player.teleport(Location(player.world, x.toDouble(), highestBlock.y.toDouble(), z.toDouble()))
                            player.sendMessage(Component.text("Teleported you to X: $x, Z: $z").color(NamedTextColor.GREEN))
                            foundSafe = true
                        }
                    }
                }
            }
        }
        
    }

}