package gg.flyte.smp.command

import gg.flyte.smp.util.randomTeleport
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Cooldown
import java.util.concurrent.TimeUnit

class RTPCommand {
    @Command("rtp")
    @Cooldown(value = 2, unit = TimeUnit.MINUTES)
    fun rtpCommand(sender: Player) {
        randomTeleport(sender)
    }
}