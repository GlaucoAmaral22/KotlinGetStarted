package functions.highOrderFunction

fun main() {

    //high order function é uma funcao que possui outra funcao como parametro ou retorna uma funcao
    fun alterAndPrintString(phrase: String, block: (String) -> Unit) {
        block(phrase)
    }

    //extension function
    fun String.upatudo(block: (String) -> Unit) {
        block(this) //block é essa funcao lambda { phrase -> println(phrase.uppercase()) }
    }


    //temos alguns jeitos de chamar a funcao
    //se o último parâmetro de uma função é uma lambda
    //então uma expressão lambda passada como o argumento correspondente pode ser colocado fora dos parênteses
    alterAndPrintString("glauco amaral") { str -> println(str.uppercase()) } //jeito mais puro
    alterAndPrintString(phrase = "glauco amaral", block = { str -> println(str.uppercase()) }) //com parametro nomeado
    "glauco amaral".upatudo(block = { phrase -> println(phrase.uppercase()) }) //com extension function

    //Passing trailing lambdas
    //Se o lambda for o único argumento DA FUNCAO, os parênteses poderão ser totalmente omitidos
    "glauco amaral".upatudo { phrase ->
        println(phrase.uppercase())
    }
    //além disso, como é um unico parametro da lambda, podemos omitir o parametro do lambda e referenciar como it
    "glauco amaral".upatudo {
        println(it.uppercase())
    }

    //Se a lambda expression tiver apenas um parametro, podemos omiti-lo e assumir o parametro como it dentro da lambda
    //obs: igual ao exemplo da linha 30
    alterAndPrintString("glauco amaral") { println(it.uppercase()) }
}