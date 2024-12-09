package functions.desestruturacao

// No Kotlin, você pode desestruturar objetos em suas propriedades diretamente nos parâmetros de uma lambda,
// desde que o objeto ofereça suporte à desestruturação por meio da função componentN.

data class Person(val name: String, val age: Int)

fun main() {
    val mappedList = listOf(Person("Glauco", 26)).map { (name, age) -> println("Nome: $name, age: $age") }

    val triples = listOf(
        Triple("Kotlin", 2024, true),
        Triple("Java", 1995, true),
        Triple("C++", 1985, false)
    )

    // Desestruturando em uma lambda:
    triples.forEach { (language, year, isModern) ->
        println("$language foi criado em $year. É moderno? $isModern")
    }
}