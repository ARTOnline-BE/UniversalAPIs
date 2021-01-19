package ikguana.all.universalapis.configbundle

import cn.nukkit.utils.ConfigSection
import ikguana.all.universalapis.UniversalAPIs
import ikguana.all.universalapis._provider.Provider

object ConfigBundle : Provider(collectionName = "configs") {
    override fun onEnable(plugin: UniversalAPIs) {
        for ((key: String, data) in plugin.config.getSection("defaultConfigs")) register(key, data as ConfigSection)
    }
}