package ikguana.all.universalapis.uaplayer

import cn.nukkit.Player
import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerChatEvent
import cn.nukkit.event.player.PlayerJoinEvent
import ikguana.all.universalapis.UniversalAPI
import ikguana.all.universalapis.UniversalAPIs
import ikguana.all.universalapis._provider.Provider
import ikguana.all.universalapis.configbundle.ConfigBundle
import ikguana.all.universalapis.linguister.Linguister

object UAPlayers : UniversalAPI(), Listener {
    private lateinit var provider: Provider
    override fun onEnable(plugin: UniversalAPIs) {
        provider = Provider(collectionName = "players")
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    fun getPlayer(name: String): UAPlayer {
        return UAPlayer(provider, name)
    }

    fun getPlayer(player: Player): UAPlayer {
        return UAPlayer(provider, player)
    }

    @EventHandler
    fun playerChatEvent(event: PlayerChatEvent) {
        var uaplayer: UAPlayer = getPlayer(event.player)
        event.format = Linguister.get(ConfigBundle.getString("players", "chat.format"), uaplayer.getPrefix(), uaplayer.player.name, event.message)
    }

    @EventHandler
    fun playerJoinEvent(event: PlayerJoinEvent) {
        var uaplayer: UAPlayer = getPlayer(event.player)
        if (uaplayer.isBanned()) event.player.kick(ConfigBundle.getString("players", "warning.strings.banned"))
    }
}