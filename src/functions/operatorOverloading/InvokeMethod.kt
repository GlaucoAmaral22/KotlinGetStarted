package functions.operatorOverloading

interface BaseUseCase {
    //o Invoke serve mais para quando tivermos uma unica acao na classe, chamarmos o objeto como methodo ao inves
    //de precisar colocar um .execute ou .process e tals
    operator fun invoke()
}

class FirstUseCase: BaseUseCase {
    override operator fun invoke() {
        println("My First UseCase")
    }

}

class SecondUseCase : BaseUseCase {
    override operator fun invoke() {
        println("My Second UseCase")
    }
}

fun main() {
    val firstUseCase = FirstUseCase()
    val secondUseCase = SecondUseCase()
    //firstUseCase.execute()
    //secondUseCase.execute()
    firstUseCase() //mesma coisa que firstUseCase.invoke()
    secondUseCase() //mesma coisa que secondUseCase.invoke()
}