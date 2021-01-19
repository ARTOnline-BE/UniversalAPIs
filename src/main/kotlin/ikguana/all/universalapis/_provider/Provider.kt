package ikguana.all.universalapis._provider

import cn.nukkit.Server
import cn.nukkit.utils.Config
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Updates
import ikguana.all.universalapis.UniversalAPI
import org.bson.Document

// Module for Data ping-pong
open class Provider(val database: String = "UniversalAPIs", collectionName: String) : UniversalAPI() {
    var collections: MongoCollection<Document>

    companion object {
        lateinit var client: MongoClient
    }

    init {
        if (client == null) {
            var cfg: Config = Server.getInstance().pluginManager.getPlugin("UniversalAPIs").config
            client = MongoClients.create(cfg.getString("mongodb.address") + ":" + cfg.getInt("mongodb.port"))
        }

        collections = client.getDatabase(database).getCollection(collectionName)
    }


    fun set(name: String, key: String, data: Any) {
        if (collections.find(Document("_id", name)).first() == null) collections.insertOne(Document("_id", name))

        collections.findOneAndUpdate(Document("_id", name), Updates.set(key, data))
    }


    fun get(name: String, key: String): Any? {
        return get(name, key, null)
    }

    fun <T> get(name: String, key: String, defaultValue: T? = null): T? {
        var doc: Document = collections.find(Document("name", name)).first()
        if (doc == null) return defaultValue;

        var tree: Document = doc
        var sp: List<String> = key.split("\\.")
        for (i in 0 until sp.size) {
            if (i == sp.size - 1) {
                return tree.get(sp.get(i), defaultValue)
            } else {
                tree = tree.get(sp.get(i), null)
                if (tree == null) return defaultValue
            }
        }
        return defaultValue
    }

    fun getString(name: String, key: String, defaultValue: String = "null"): String {
        return get(name, key, defaultValue)!!
    }

    fun getBoolean(name: String, key: String, defaultValue: Boolean= false): Boolean {
        return get(name, key, defaultValue)!!
    }

    fun getInt(name: String, key: String, defaultValue: Int = 0): Int {
        return get(name, key, defaultValue)!!
    }

    fun register(name: String, map: Map<String, Any>) {
        var doc: Document = Document("_id", name)
        doc.putAll(map)
        if (collections.find(Document("_id", name)).first() == null) collections.insertOne(doc)

    }

    fun remove(name: String, key: String) {
        collections.findOneAndUpdate(Document("_id", name), Updates.unset(key))
    }

    fun exist(name: String, key: String): Boolean {
        return false
    }
}