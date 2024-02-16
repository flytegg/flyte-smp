package gg.flyte.smp.command

import gg.flyte.twilight.scheduler.async
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Cooldown
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class NVCommand {
    @Command("nv", "nightvision")
    fun nvCommand(sender: Player) {
        sender.addPotionEffect(
            PotionEffect(
                PotionEffectType.NIGHT_VISION,
                Integer.MAX_VALUE,
                1,
                false,
                false,
                false
            )
        )
    }
}