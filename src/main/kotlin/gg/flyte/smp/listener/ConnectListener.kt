package gg.flyte.smp.listener

import gg.flyte.smp.util.randomTeleport
import gg.flyte.twilight.event.event
import gg.flyte.twilight.scheduler.delay
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class ConnectListener : Listener {

    init {
        event<PlayerJoinEvent> {
            joinMessage(MiniMessage.miniMessage().deserialize("<gray>[<green>+</green>] ${player.name} has joined."))

            delay {
                randomTeleport(player)
            }
        }

        event<PlayerQuitEvent> {
            quitMessage(MiniMessage.miniMessage().deserialize("<gray>[<red>+</red>] ${player.name} has quit."))
        }

    }
}