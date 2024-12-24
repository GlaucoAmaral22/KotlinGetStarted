package coroutines

import kotlin.random.Random
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val deferred: Deferred<String> = async {
        delay(Random.nextLong(1483, 3781))
        "Resultado da operacao assincrona"
    }

    println("Fazendo outras coisas enquanto a operação é processada...")

    // Aguarda o resultado da operação assíncrona
    val result = deferred.await() //aguarda enquanto nao tem resposta

    println("Operação concluída! Resultado: $result")

    println("Iniciando o download...")

    // Disparamos duas operações assíncronas
    val data1 = async { downloadData("https://api.example.com/data1") }
    val data2 = async { downloadData("https://api.example.com/data2") }

    println("Download concluído!")
    println("Dados 1: ${data1.await()}")
    println("Dados 2: ${data2.await()}")
}

// Função simulando um download assíncrono
suspend fun downloadData(url: String): String {
    delay(2000) // Simulando tempo de espera (2 segundos)
    return "Dados de $url"
}