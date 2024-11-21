package scopeFunction

data class Person(val name: String, var age: Int, val country: String) {
    fun incrementAge() = age++
}


fun main() {

    //Basicamente, todas essas funções executam a mesma ação: executar um bloco de código em um objeto.
    // A diferença é como esse objeto fica disponível dentro do bloco e qual é o resultado de toda a expressão.

    //let -> tem o intuito de retornar o resultado do bloco
    //Usos comuns: verificar nulidade (?.let { ... }), transformar dados ou executar operações que retornam algo.
    val length = "Kotlin".let {
        println("O valor do objeto é $it. Ele será retornado")
        it.length
    }
    println("O tamanho na palavra acima é $length")

    val canBeNull = 10
    val result = canBeNull?.let {
        println("Não é nula")
        it + 10
    }
    println("Valor do resultado é $result")

    //also
    //retorna o proprio objeto que invocou
    //Usos comuns: adicionar ações que não modificam o objeto (como log ou validação).
    "Kotlin".also {
        println("O tamanho da palavra no also é: ${it.length}")
        println("O retorno do also sempre será o proprio objeto que está invocando")
        println("Logando algo do objeto")
    }

    //run
    //Usos comuns: inicializar ou processar um objeto de maneira complexa e retornar um resultado específico.
    val x: Int? = null
    val resultProcess = x ?: run {
        println("Executa tal coisa e retorna o objeto")
        10
    }
    println("O Valor do resultProcess é: $resultProcess")

    println("Kotlinnn".run {
        println("valor objeto: $this")
        this.length
    })

    //with
    //retorna o resultado do bloco de codigo
    //Diferente das outras, with não é uma função de extensão, então você passa o objeto como argumento.
    // Ela usa this como o contexto e retorna o resultado do bloco de código.
    //Usos comuns: realizar várias operações em um objeto existente.
    val name = "Kotlin"
    val withResult = with(name) {
        println("Executando bloco de codigo with")
        name.length + 3
    }
    println("Resultado do with: $withResult")


    //apply
    //A função apply executa um bloco de código no contexto do objeto (this)
    // e retorna o próprio objeto, o que é útil para inicialização e configuração de objetos.
    //Usos comuns: inicializar ou configurar objetos (especialmente no padrão builder).
    Person("Glauco Amaral", 26, "Brasil").apply {
    }

    //apply e also -> retornam o objeto
    //let, run, with -> retornam o ultimo comando do bloco de codigo


}