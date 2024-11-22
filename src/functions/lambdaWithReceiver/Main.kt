package functions.lambdaWithReceiver


fun main() {
    val sum = { a: Int, b: Int -> a + b } //lambda. same as: val sum: (Int, Int) -> (Int) = { a: Int, b: Int -> a + b }
    val soma = fun(a: Int, b: Int): Int = a + b //anonymous function
    println(sum(1, 3))
    println(soma(1, 3))

    val printa: () -> Unit = { println("Hello World") }
    printa()

    //A.(B) -> C represents functions that can be called on a receiver object A with a parameter B and return a value C
    val sumTwo: Int.(Int) -> Int = { a -> a + this } //A refere-se ao ``
    val somaTwo = fun Int.(other: Int): Int = this + other
    println(sumTwo(10, 20))
    println(somaTwo(10, 20))

    //Imagine que você tem um objeto chamado caderno. Para adicionar algo nele, normalmente você faz assim:
    val caderno = StringBuilder()
    caderno.append("Minha anotação 1")
    caderno.append("Minha anotação 2")
    println(caderno.toString())

    //Com lambda com receiver, o caderno vira o receiver, e você escreve o código como se estivesse dentro dele, sem precisar repetir caderno. toda vez.
    val texto = buildString {
        append("x")
        append("y")
    }
    println(texto)



}