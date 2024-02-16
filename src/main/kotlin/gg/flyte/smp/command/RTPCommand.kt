package gg.flyte.smp.command

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Location
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Cooldown
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class RTPCommand {
    @Command("rtp")
    @Cooldown(value=2, unit=TimeUnit.MINUTES)
    fun rtpCommand(sender: Player) {
        var foundSafe = false
        val random = Random.Default

        sender.sendMessage(Component.text("Finding you a safe location...").color(NamedTextColor.GREEN))

        while(!foundSafe) {
            val x = random.nextInt(1024)
            val z = random.nextInt(1024)

            val highestBlock = sender.world.getHighestBlockAt(x, z)

            if(!highestBlock.isEmpty && highestBlock.isSolid) {
                sender.teleport(Location(sender.world, x.toDouble(), highestBlock.y.toDouble(), z.toDouble()))
                sender.sendMessage(Component.text("Teleported you to X: $x, Z: $z").color(NamedTextColor.GREEN))
                foundSafe = true
            }
        }
    }
}