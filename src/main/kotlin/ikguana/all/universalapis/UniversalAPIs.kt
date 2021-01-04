package ikguana.all.universalapis

import cn.nukkit.plugin.PluginBase
import ikguana.all.universalapis.antenna.Antenna

object UniversalAPIs : PluginBase() {
    override fun onLoad() {
        logger.info("Loading APIs...")
        saveDefaultConfig()

        Antenna()
        logger.info("Opening socket for database")
    }
}