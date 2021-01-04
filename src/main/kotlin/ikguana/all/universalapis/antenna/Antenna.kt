package ikguana.all.universalapis.antenna

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients

// Module for Data ping-pong
class Antenna {
    var mongo: MongoClient

    init {
        mongo = MongoClients.create()
    }

    fun set(database: String, name: String, key: String, data: Object) {
    }
    fun get(database: String, name: String, key: String) {
    }
    fun remove(database: String, name: String, key: String){
    }
}
