package ikguana.all.universalapis.uaplayer;

import cn.nukkit.Player
import cn.nukkit.Server
import ikguana.all.universalapis._provider.Provider
import ikguana.all.universalapis.configbundle.ConfigBundle

class UAPlayer {
    val provider: Provider
    val player: Player

    constructor(provider: Provider, name: String) {
        this.provider = provider
        this.player = Server.getInstance().getPlayer(name)
    }

    constructor(provider: Provider, player: Player) {
        this.provider = provider
        this.player = player
    }

    //Money
    fun getMoney(): Int {
        return provider.getInt(player.name, "money")
    }

    fun addMoney(money: Int) {
        provider.set(player.name, "money", getMoney() + money)
    }

    //Warning
    fun getWarning(): Int {
        return 0
    }

    fun addWarning(count: Int, reason: String) {}
    fun minWarning(count: Int, reason: String) {}
    fun isBanned(): Boolean {
        return (player.isBanned || (getWarning() >= ConfigBundle.getInt("players", "warning.maxWarning")))
    }

    //Prefix
    fun addPrefix(prefix: String) {}
    fun getPrefix(): String {
        return "defaultprefix"
    }

    fun getAllPrefix(): ArrayList<String> {
        return ArrayList()
    }

    fun removePrefix(idx: Int) {}
}
