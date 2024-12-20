package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main(): Unit = runBlocking {
    //builder para criar de escopo de coroutines
    //se uma coroutine falhar, NAO cancela todas as outras
    //escopo eh basicamente onde as coroutinas serao executadas, como se relacionam entre si
    supervisorScope {
        //lanca uma coroutina dentro do escopo criado
        launch {
            delay(1400)
            println("Primeira coroutina")
            throw RuntimeException()
        }
        launch {
            delay(1459)
            println("Segunda coroutina")
        }
    }
    println("Final da execucao")
}
