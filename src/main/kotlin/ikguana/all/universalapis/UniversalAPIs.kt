package ikguana.all.universalapis

import cn.nukkit.plugin.PluginBase
import cn.nukkit.utils.Config
import ikguana.all.universalapis._provider.Provider
import ikguana.all.universalapis.configbundle.ConfigBundle
import ikguana.all.universalapis.linguister.Linguister
import ikguana.all.universalapis.papyrus.Papyrus
import ikguana.all.universalapis.simpledialog.SimpleDialog
import ikguana.all.universalapis.uaplayer.UAPlayers
import java.util.logging.Level
import java.util.logging.Logger

class UniversalAPIs : PluginBase() {
    companion object {
        lateinit var cfg: Config
        val apis: ArrayList<UniversalAPI> = ArrayList()
    }

    override fun onLoad() {
        logger.info("Loading APIs...")

        //Disable MongoDB CONSOLE Log
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE)

        saveDefaultConfig()
        cfg = config

        // Make INSTANCE
        Provider

        ConfigBundle
        SimpleDialog

        Linguister
        Papyrus

        UAPlayers
    }

    override fun onEnable() {
        for (api in apis) api.onEnable(this)
    }

    override fun onDisable() {
        for (api in apis) api.onDisable(this)
    }
}