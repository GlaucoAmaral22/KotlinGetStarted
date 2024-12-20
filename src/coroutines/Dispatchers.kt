package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//DISPATCHERS determinam QUAL THREAD sera executada a coroutine
//SE NAO INFORMADA, SERA NA THREAD ATUAL (POR DEFAULT)

fun main() {

    //executa em um pool de threads dedicado para I/O.
    CoroutineScope(Dispatchers.IO).launch {
        println("Executando em Dispatchers.IO: ${Thread.currentThread().name}")
    }

    //executa em um pool de threads para operações computacionais.
    CoroutineScope(Dispatchers.Default).launch {
        println("Executando em Dispatchers.Default: ${Thread.currentThread().name}")
    }

    println("Seguindo o fluxo na thread main: ${Thread.currentThread().name}")
    Thread.sleep(3000)
    println("Finalizando execucao")
}