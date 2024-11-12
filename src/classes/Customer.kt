package classes

//recomendado sempre com val, ao menos que futuramente voce vá alterar o valor
class Customer(val name: String, val age: Int, val propertyWithDefaultValue: String = "Default value") {
    val children: Int = 0

    fun printInfo() {
        println("My name is $name and i am $age years old. $propertyWithDefaultValue")
    }
}

data class User(val name: String, val id: Int) {
}


fun main() {
    val person1: Customer = Customer("Glauco Amaral", 26)
    person1.printInfo()


    val person2: Customer = Customer("Glauco Amaral", 26, "testess")
    person2.printInfo()

    val user1: User = User("Glauco", 2)
    val user2: User = User("Glauco", 2)

    if (user1 == user2) {
        println("Usuarios com as mesmas informacoes")
    }
    println("Hashcode user 1: ${user1.hashCode()}, Hashcode user2: ${user2.hashCode()}")

    println("testando toString: ${user1.toString()}")




}