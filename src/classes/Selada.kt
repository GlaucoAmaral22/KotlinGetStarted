package classes

import kotlin.random.Random

//ESSE TRECHO DE CODIGO É DE UMA LIB PUBLICA
//sealed class
//É uma classe abstrata que vai selar as herancas somente para classes do pacote, com isso voce tem controle de todas possiveis herancas.
//É semelhante a enum

sealed interface Error

sealed class IOError : Error {}

class FileError(val fileName: String) : IOError() {}
class DatabaseError(val db: String): IOError() {}
class MemoryError() : IOError()
//class NovoError(): IOError() //se eu descomentar, ele vai acusar que o tipo de error no when abaixo deve ser exaustivo e eu saber o que fazer com o erro



fun handleError(error: IOError) {
    when(error) {
        is FileError -> println("Erro no arquivo ${error.fileName}")
        is DatabaseError -> println("Erro no banco de dados: ${error.db}")
        is MemoryError -> println("Erro de memória")
    }
}

fun makeIORequest(): IOError {
    val random = Random.nextInt(3)
    return when(random) {
        0 -> FileError("teste.txt")
        1 -> DatabaseError("conection master")
        2 -> MemoryError()
        else -> throw IllegalStateException("Erro desconhecido")
    }
}

fun main() {
    val error: IOError = makeIORequest()
    handleError(error)

}