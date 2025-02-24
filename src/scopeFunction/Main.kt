package scopeFunction

data class Person(var name: String = "Default Value", var age: Int = -1)

fun main() {
    //Scope function são funções highOrder(recebem/retornam outra função).
    //Objetivo delas é executar determinadas operações num objeto num escopo.
    //Cada uma tem o seu caso de uso, mas o intuíto delas é fazer um código: conciso, legível e expressivo.

    //LET: Executar um bloco de código somente se o objeto é nulo.
    /**
     * object?.let {
     *     // perform operations on the object
     * }
     */
    val message = "Hello World"
    val result = message.let {
        val uppercase = message.uppercase()
        uppercase.reversed()
    }
    println(result)

    val nullable: String? = null
    nullable?.let { println("Objeto não nulo") }

    //ALSO: Executar algumas operações adicionais sem mudar o estado dele e então retornar o próprio objeto.
    /**
     * object.also {
     *     // perform additional operation on the object
     * }
     */
    val messageAlso = "Hello World!"
    messageAlso.also {
        println("The original message is: $it")
    }.run {
        uppercase()
    }.also {
        println("The uppercase message is: $it")
        println("Salvando dados no banco...")
    }
    println("Valor do messageAlso continua inalterado: $messageAlso")

    //APPLY: Configurar as propriedades de um objeto e retorná-lo.
    /**
     * object.apply {
     *     // configure the properties of the object
     * }
     */
    Person().apply {
        name = "Glauco Amaral Geraldino"
        age  = 26
    }

    val person = Person("Glauco", 26)
    person.apply {
        age = 27
        name = "Amaralzinho"
    }
    println("$person")

    //RUN: Executar um bloco de código num objeto e retornar o resultado do bloco
    /**
     * object.run {
     *     // perform the block of code on the object
     * }
     */
    val nameUppercase = person.run {
        this.name.uppercase()
    }
    println(nameUppercase)

    //WITH: Executar um bloco de código num objeto sem a necessidade de chamar o objeto dentro do bloco
    /**
     * with(object) {
     *     // perform the block of code on the object
     * }
     */
    val withResult = with(person) {
        "Name and Age inside with block: $name, $age"
    }
    println(withResult)
}