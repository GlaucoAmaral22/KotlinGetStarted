package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //Executa um condigo suspendivel em uma funcao nao suspendivel
    //Bloqueia a thread atual ate que a coroutine termine
    //Utilizado para testes ou blocos de inicialização síncronos.
    runBlocking {
        println("Iniciando...")
        delay(1000)
        println("Finalizando!")
    }

    runBlocking {
        launch {
            delay(2000)
            println("launching 1...")
        }
        launch {
            println("launching 2...")
            delay(332)
        }
    }

    println("Ultimo comando a ser executado.")
}