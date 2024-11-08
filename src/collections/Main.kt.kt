package collections

//Lists are Ordered collections of items
//Maps are Unique unordered collections of items
//Sets of key-value pairs where keys are unique and map to only one value
fun main(){

    //lists
    val readOnlyList: List<String> = listOf("item 1", "item 2", "item 3") // val readOnlyList: List<String> = listOf("String 1", "String 2", "String3")
    println(readOnlyList)

    val mutableList: MutableList<String> = mutableListOf("im 1", "im 2", "im 3")
    println(mutableList)
    mutableList.add("im 4")
    println(mutableList)

    println("Primeira posicao list: ${readOnlyList[0]}")
    println("Primeira posicao mutableList: ${mutableList.first()}")

    println("Ultima posicação list: ${readOnlyList.last()}")
    println("Ultima posicação mutableList: ${mutableList[mutableList.lastIndex]}")

    println("Quantidade de itens: ${readOnlyList.count()}")
    print("Contem im 1? ${"im 1" in mutableList}") //operator in para saber se o Item está na lista
    println()


    //sets
    val readOnlySet = setOf(1,2,3);
    println(readOnlySet)

    var mutableSet = mutableSetOf(4,5,6);
    mutableSet.add(4)
    println(mutableSet)

    //para prevenir alterações em cima de uma mutable, voce pode atribuir ela a um Set e vc tera uma mutable mas blocked.
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    val fruitLocked: Set<String> = fruit
    //fruitLocked.add("teste") //vai dar ruim

    println("Quantidade de items do set: ${fruit.count()}") //3 pq o cherry é unico em um CONJUNTO
    println("Banana está no set: ${"banana" in fruit}")

    fruit.add("strawberry")
    fruit.remove("cherry")
    println("Set após adicao e remoção: $fruit")


    //maps
    val mapReadOnly: Map<String, Int> = mapOf("Glauber" to 1, "Glauco" to 2, "Glaucia" to 3)
    println(mapReadOnly)

    var muutableMap: MutableMap<String, String> = mutableMapOf("1" to "2", "2" to "3")
    println(muutableMap)

    println("Para acessar o valor da chave Glauber: ${mapReadOnly["Glauber"]}")
    println("Para acessar o valor de chave inexistente: ${mapReadOnly["inexistente"]}")

    muutableMap["chaveNova"] = "10"
    println(muutableMap)

    muutableMap.remove("1")
    println(muutableMap)

    println("Quantidade de itens no map: ${muutableMap.count()}")
    println("Contem key 'X' no map: ${muutableMap.containsKey("X")}")
    println("Contem key '2' no map: ${muutableMap.containsKey("2")}")
    println("Todos os values:  ${muutableMap.values}")

}
