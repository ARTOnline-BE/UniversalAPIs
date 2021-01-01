package ikguana.all.universalapis

import cn.nukkit.plugin.PluginBase
import ikguana.all.universalapis.antenna.Antenna
import ikguana.all.universalapis.chat.Chat
import ikguana.all.universalapis.chat.Prefix
import ikguana.all.universalapis.configbundle.ConfigBundle
import ikguana.all.universalapis.linguister.Linguister
import ikguana.all.universalapis.money.Money
import ikguana.all.universalapis.papyrus.Papyrus
import ikguana.all.universalapis.simpledialog.SimpleDialog
import ikguana.all.universalapis.warning.Warning

class UniversalAPIs : PluginBase() {
    override fun onLoad() {
        logger.info("Loading APIs...")

        Antenna()
        logger.info("Opening socket for database")

        Chat(this)
        logger.info("Loading API Chat")
        Prefix(this)
        logger.info("Loading API Prefix...")
        ConfigBundle(this)
        logger.info("Loading API ConfigBundle")
        Linguister(this)
        logger.info("Loading API Linguister")
        Money(this)
        logger.info("Loading API Money")
        Papyrus(this)
        logger.info("Loading API Papyrus")
        SimpleDialog(this)
        logger.info("Loading API SimpleDialog")
        Warning(this)
        logger.info("Loading API Warning")

    }
}