package labels


class A(val name: String, val b: B)

data class B(val name: String)


fun A.print(): Unit = with(b) {
    println("Variável name do contexto this do with: ${this.name}")
    println("Variável name do contexto this da classe A: ${this@print.name}")
}

// Quando há ambiguidades devido a nomes idênticos em escopos diferentes.
// Ajuda a deixar o código mais claro e legível
fun main() {
    val classA = A(
        name = "Glauco",
        b = B(
            name = "Glauco Amaral"
        )
    )

    classA.print()
}