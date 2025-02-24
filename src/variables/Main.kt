package variables

//Variables can be declared outside the collections.control_flow.main() function at the beginning of your program. Variables declared in this way are said to be declared at top level.
//We recommend that you declare all variables as read-only (val) by default. Declare mutable variables (var) only if necessary.

fun main() {
    //We have two variable types:
    //val -> read-only
    //var -> muttable
    val popcorn = 5
    val hotdog = 1
    var customer = 10
    customer = 8

    //String templates para printar
    println("We have $customer customers.")
    println("We have ${customer + 1} customers.")

    //Kotlin makes inference to variables
    //https://kotlinlang.org/docs/basic-types.html

    customer += 2
    customer -= 2
    customer *= 2
    println("Customer: $customer")
    customer /= 2;
    println("Customer: $customer")

    val byte: Byte = 127 //Como é uma variavel inteira com 8bits com sinal, restam 7 bits para numero com o maior valor igual a 127. (2^7 - de 0 até 127)
    println("Valor variavel byte: $byte")
    println("Valor maximo para byte: ${Byte.MAX_VALUE}")

    val string: String = "Hello World"
    println(string)

    //Voce pode criar uma variável e inicializar ela depois, mas deve colocar o tipo na declaração
    val variable: Int
    variable = 10
    println(variable)

    val glauco: String
    glauco = "Glauco Amaral Geraldino"
    println("Meu nome é: $glauco")
    
    val a: Byte = 100
    val b: Short = 32000
    val c: Int = 100000
    val d: Long = 10000000000L
    val e: Float = 3.14f
    val f: Double = 3.141592653589793

    println("Byte: $a")
    println("Short: $b")
    println("Int: $c")
    println("Long: $d")
    println("Float: $e")
    println("Double: $f")
}




