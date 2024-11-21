package functions.operatorOverloading

//No Kotlin, o operator overloading (sobrecarga de operadores) permite que você defina o comportamento de operadores
//como +, -, *, [], etc., para tipos personalizados. Isso torna o código mais expressivo e fácil de usar.
//Você pode sobrecarregar operadores em Kotlin implementando funções específicas e marcando-as com a palavra-chave operator.
//O Kotlin associa operadores a nomes de funções padrão, e, ao definir essas funções em sua classe, você altera o comportamento desses operadores.


data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(this.x + other.x, this.y + other.y)
    }

    operator fun unaryMinus() = Point(-x, -y)
}

data class Person(val name: String)

class TestOne() {
    var listAdds: MutableList<Any> = mutableListOf()

    operator fun plus(parameterToAdd: Any) {
        listAdds.add(parameterToAdd)
    }
}

fun main() {
    val point1 = Point(10, 20)
    val point2 = Point(30, 40)
    val pointSum: Point = point1 + point2
    println("Point sum: $pointSum")
    println("unaryMinus: ${-pointSum}")

    val test = TestOne()
    test + point1
    test + point2
    println(test.listAdds[0])
    println(test.listAdds[1])
}