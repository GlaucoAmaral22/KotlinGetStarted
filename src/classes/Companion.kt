package classes

//o companion serve mais para substituir o static do java. Geralmente seu uso associa-se a
//para o uso de factories, onde é necessario um construtor privado
class Button private constructor(val v: String, val count: Int) {
    companion object {
        private var count = 0;
        fun newObject (): Button = Button("Botao de ID: $count", count++)
    }
}

fun main() {
    val button1: Button = Button.newObject()
    val button2: Button = Button.newObject()
    val button3: Button = Button.newObject()
    println(button1.v)
    println(button2.v)
    println(button3.v)
}