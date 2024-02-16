package gg.flyte.template

import gg.flyte.template.command.PingCommand
import gg.flyte.template.listener.JoinListener
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
            register(PingCommand())
            registerBrigadier()
        }

        JoinListener()

        PaperLib.suggestPaper(this)
    }
}