package coroutines

import java.util.Random
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


//Coroutine é a instancia de uma computação suspendivel
//Coroutine é semelhante a Thread, só que ao nivel de controle da linguagem e não do SO
//Ela pode comecar a ser executada na Thread X e finaliar na Y
//Ela trabalha em cima do conceito de CONCORRENCIA e não PARALELISMO

// runblocking no Kotlin é frequentemente usado como uma ponte entre o código bloqueante e não bloqueante.
// Ele permite que você execute código assíncrono (baseado em corrotinas) dentro de um ambiente bloqueante,
// como a função main de um aplicativo ou em um teste unitário, onde a API do Kotlin exige que o código seja síncrono.

//Runs new coroutine and blocks current thread interruptibly until its completion -> nao usar em produção pq bloqueia a thread atual que chamou
//Coroutina só pode ser lancada dentro de um CoroutineScope(escopo que delimita o ciclo de vida da coroutina

fun main() {
    runBlocking {  // é um coroutine builder tb que serve como PONTE de um mundo non-coroutine da main()(pq a main é uma THREAD e ela pode ser bloqueante) com o codigo dentro do launch
        doWorld()
        println("Done")
//        (1..3).forEach { launch { startNewCoroutine(it) } }
    }
}

// uma funcao `suspend` quer dizer que ela é suspendível
// esse tipo de funca pode ser chamada dentro de coroutinas
// e também chamar outras funcoes suspendiveis, como `delay`
suspend fun doWorld() {
    // coroutineScope é um coroutineScope builder.
    // Ele cria o escopo da coroutina e não completa enquanto todas as coroutinas filhas lancadas não forem completadas
    // Diferenças entre os dois builders runBlocking e coroutineScope:
    // 1. runBlocking BLOQUEIA a thread atual em espera enquanto coroutineScope apenas suspend, liberando a thread para outro uso
    // 2. runBlocking é uma regular function enquanto coroutineScope uma suspend function
    // coroutineScope pode ser usado dentro de qualquer suspend function para executar inumeras operacoes concorrentes
    coroutineScope {
        //no exemplo abaixo estou lancando duas COROUTINAS para concorrenem no uso de thread
        //enquanto o processo do escopo da coroutina não terminar, o fluxo não segue em diante.
        launch { //é um coroutine builder. Ele lança uma nova coroutina CONCORRENTEMENTE com o resto do codigo.
            delay(3_000L) // é uma funcao suspend tb que irá SUSPENDER a execução da coroutine
            print("World") //printa depois do atraso
        }
        launch { //outra coroutine
            delay(4_000L)
            println("!!!")
        }
        print("Hello ") // coroutina principal continua enquanto a anterior é atrasada
    }

}

suspend fun functionTestCoroutine() {
    coroutineScope { //só pode ser chamado dentro de uma coroutina ou uma funcao suspensa
        launch {
            delay((2000..3000).random().toLong())
            println("valor da coroutina 1")
        }
        launch {
            delay((2000..3000).random().toLong())
            println("valor da coroutina 2")
        }
        launch {
            delay((2000..3000).random().toLong())
            println("valor da coroutina 3")
        }
    }
    // vai ser exibido por ultimo porque
    // o coroutineScope suspende a função chamadora sem bloquear a Thread
    // e aguarda finalização das coroutinas.
    println("Aguardando inicio execução: ")
}

suspend fun startNewCoroutine(coroutineNumber: Int) {
    println("executando corotina: $coroutineNumber")
    delay((2000..4000).random().toLong())
    println("finalizando corotina: $coroutineNumber")

}
















