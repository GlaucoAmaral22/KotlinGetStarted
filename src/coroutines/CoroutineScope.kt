package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    //builder para criar de escopo de coroutines
    //se uma coroutine falhar, cancela TODAS as outras
    //SCOPE(ESCOPO) eh basicamente onde as coroutinas serao executadas, como se relacionam entre si
    coroutineScope {
        //lanca uma coroutina dentro do escopo criado
        launch {
            delay(1400)
            println("Primeira coroutina")
            throw RuntimeException()
        }
        launch {
            delay(2000)
            println("Segunda coroutina")
        }
    }
    println("Final da execucao")
}
