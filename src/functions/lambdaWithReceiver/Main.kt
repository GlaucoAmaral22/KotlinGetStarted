package functions.lambdaWithReceiver

fun buildString(configure: (StringBuilder) -> Unit): String {
    val stringBuilder = StringBuilder()
    configure(stringBuilder) //invocando o configure que é um bloco de codigo (lambda, funcao)
    return stringBuilder.toString()
}

fun buildStringWithLambdaReceiver(configure: (StringBuilder).() -> Unit): String {
    val stringBuilder = StringBuilder()
    configure(stringBuilder)
    return stringBuilder.toString()
}

fun main() {
    //Sem receiver precisamos 'mencionar' o parametro, seja com o it ou sem o it e demais parametros
    val result = buildString {
        it.append("Kotlin ")
        it.append("é ")
        it.append("Foda")
    }
    println(result)

    //Com receiver, não precisamos 'mencionar' o parametro e objeto é injetado implicitamente como receptor(this)
    val resultWithLambdaReceiver = buildStringWithLambdaReceiver {
        append("Kotlin ") //mesma coisa que this.append()
        append("é ")
        append("Foda ")
    }
    println(resultWithLambdaReceiver)


    //Function types with receiver, such as A.(B) -> C, can be instantiated with a special form of function literals
    // – function literals with receiver.
    //Inside the body of the function literal, the receiver object (A.) passed to a call becomes an implicit this,
    //so that you can access the members of that receiver object without any additional qualifiers, or access the receiver object using a this expression.
    val crazy: Int.(String) -> Unit = { other ->
        print("Valor de this: $this, ")
        println("Valor de other: $other")
    }
    crazy(10, "Glauco")

    //Voce pode até usar com mais de 2 parametros, mas o `this` será sempre do receiver(A)
    val sumTriple: Int.(Int, Int) -> Int = { secondInt, thirdInt -> this + secondInt + thirdInt }
    println("Valor da soma tripla: ${sumTriple(1, 2, 3)}")

    fun operationInTriple(value1: Int, value2: Int, value3: Int, operation: Int.(Int, Int) -> Unit) {
        operation(value1, value2, value3)
    }

    operationInTriple(1, 2, 3) { value2, value3 ->
        println(this + value2 + value3)
    }

    operationInTriple(10, 10, 10) { value2, value3 ->
        println(this * value2 * value3)
    }


}