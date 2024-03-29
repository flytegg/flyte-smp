package gg.flyte.smp

import gg.flyte.smp.command.NVCommand
import gg.flyte.smp.command.RTPCommand
import gg.flyte.smp.listener.ConnectListener
import gg.flyte.twilight.Twilight
import gg.flyte.twilight.twilight
import io.papermc.lib.PaperLib
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitCommandHandler

class FlyteSMP : JavaPlugin() {

    companion object {
        val instance by lazy { Twilight.plugin }
    }

    override fun onEnable() {
        twilight(this) { }

        BukkitCommandHandler.create(this).apply {
            enableAdventure()

            register(
                RTPCommand(),
                NVCommand()
            )

            registerBrigadier()
        }

        ConnectListener()

        PaperLib.suggestPaper(this)
    }
}