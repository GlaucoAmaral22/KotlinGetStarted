package functions

import kotlin.math.PI


fun helloWorld() {
    println("Hello World")
}


fun soma(x1: Int, x2: Int): Int {
    return x1 + x2
}

//o jeito acima com bracket é necessario declarar o tipo de retorno
fun sum(x1: Int, x2: Int) = x1 + x2

fun namedArguments(x1: Int, x2: Int) {
    println("Argumento x1: $x1")
    println("Argumento x2: $x2")
}

fun defaultValue(argument1: String, argument2: String = "Valor default") {
    println("$argument1 $argument2")
}

fun circleArea(x: Int) = x * x * PI


fun main() {
    helloWorld()
    println("Valor da soma: ${soma(1, 2)}")
    println("Valor da soma: ${sum(1, 2)}")
    namedArguments(10, 20)
    namedArguments(x2 = 10, x1 = 20)
    defaultValue("lalala")
    println(circleArea(10))

    //Expressões lambda podem ser difíceis de entender à primeira vista, então vamos detalhar. Expressões lambda são escritas entre chaves {}.
    //
    //Dentro da expressão lambda, você escreve:
    //
    //Os parâmetros seguidos por um ->.
    //
    //O corpo da função após ->.

    //{ parâmetro(s) -> expressão }

    //lambda function sem type
    val upperCaseString = { text: String, number: Int -> text.uppercase() + " " + number }
    println(upperCaseString("hello world", 10))


    val lambaSemParametro = { println("executando lambda sem parametro") }
    lambaSemParametro()


    val numbers = listOf(1,2,3,4,5,6,7,8,9,10)
    println("Somente os numeros pares: " + numbers.filter {number: Int -> (number % 2) == 0 })
    println("Somente os numeros dobrados: " + numbers.map { number: Int -> number * 3 })


    //lambda function com TYPEEE
    val stringToUpperCaseWithfunctionType: (String) -> String = {x:String -> x.toUpperCase()}
    println(stringToUpperCaseWithfunctionType("hellooooooo com type"))


    val lambdaSomaComParametro: (Int, Int) -> Int = {valor1: Int, valor2: Int -> valor1 + valor2}
    println(lambdaSomaComParametro(1,2))

    //Lambda com um unico comando
    val square = { x: Int -> x * x }
    println(square(5))

    //lambda com varios comandos
    val lambdaComVariosParametro = {x: Int, y: Int ->
        println("Valor de x na lambdaComVariosParametro: $x")
        println("Valor de y na lambdaComVariosParametro: $y")
        x + y
    }
    println(lambdaComVariosParametro(10,25))

}