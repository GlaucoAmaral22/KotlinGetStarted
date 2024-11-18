package classes

import javax.xml.crypto.Data

//Object é mais utilizado para SingleTons
object DatabaseManager {
    private const val DB_URL = "123.456.789"

    public fun conect() {
        println("Conectando ao banco de host $DB_URL")
    }

}

fun main() {
    DatabaseManager.conect()
}