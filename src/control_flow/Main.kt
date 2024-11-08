package control_flow

fun main() {

    val check: Boolean = true

    if (check) {
        println("true")
    } else {
        println("false")
    }

    var a = 28;
    val b = 210;
    println(if (!check) a else b)

    val value = 10

    when (value) {
        1 -> println(a)

        10 -> {
            a = 19; println(a)
        }

        15 -> {
            println("15")
        }
    }

    val hello = "Hello"


    val vvv: Boolean = false

    when (vvv) {
        true -> println("true")
        false -> println("true")
    }


    //devemos sempre usar o 'else' quando for pra atribuição
    val result = when (hello) {
        "1" -> "One"
        "Hello" -> "Vai curintia"
        else -> "caiu no else"
    }

    println(result)

    println(
        when (hello) {
            "1" -> "One"
            "Hello" -> "Vai curintia"
            else -> "caiu no else"
        }
    )

    for (number in 1..10) {
        print("$number ,")
    }

    println()

    for (number in 10 downTo -5) {
        print("$number ,")
    }

    println()

    for (char in 'a'..'z') {
        print("$char, ")
    }

    println()

    //collections tambem podem ser iteradas
    val lisxt: List<Int> = listOf(1,10,9,1,299,29)
    for (number in lisxt) {
        print("$number, ")
    }

    println()

    val pizza = listOf("Calabresa", "Morango", "Chocolate")
    for (sabor in pizza) {
        print("$sabor, ")
    }

    println()

    var bolosComidos = 0;
    while (bolosComidos < 3) {
        print("$bolosComidos, ")
        bolosComidos++
    }

    do {
        bolosComidos++
        print("$bolosComidos")
    } while (bolosComidos < 6)


    println()

    var oo = 10;
    println("valor de oo: ${oo++}")
    println("valor de oo: ${oo++}")


}