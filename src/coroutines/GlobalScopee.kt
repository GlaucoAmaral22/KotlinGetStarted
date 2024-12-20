package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    //Escopo vivo durante a aplicacao inteira
    //Tem que saber o motivo que esta usando de fato
    //Se usado erroneamente pode causar problemas de memória
    GlobalScope.launch {
        delay(1400)
        println("Executando minha coroutine no escopo global 1")
    }

    GlobalScope.launch {
        println("Executando minha coroutine no escopo global 2")
    }

    GlobalScope.launch {
        println("Executando minha coroutine no escopo global 3")
    }

    //Como o GlobalScope eh assincrono, ele continua o fluxo e nao bloqueia a Thread atual.
    //Cada Coroutine sera executada de forma assíncrona e nao bloqueia o fluxo de execucao do código principal
    //Eu deixei o sleep para a thread esperar a execucao da primeira coroutine
    Thread.sleep(2000)
}