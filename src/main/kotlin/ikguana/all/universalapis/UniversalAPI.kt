package ikguana.all.universalapis

abstract class UniversalAPI {
    init {
        UniversalAPIs.apis.add(this)
    }

    open fun onEnable(plugin: UniversalAPIs) {}

    open fun onDisable(plugin: UniversalAPIs) {}

    open fun close() {
    }
}