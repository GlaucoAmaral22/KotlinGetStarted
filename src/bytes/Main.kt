package bytes

fun main() {
    val byteArrayDec = byteArrayOf(72, 101, 108, 108, 111)
    //Tanto Charsets.US_ASCII quanto Charsets.UTF_8 irão imprimir o mesmo conteudo
    //pelo fato do UTF_8 ser compatível com ASCI
    val string = String(byteArrayDec, Charsets.US_ASCII)
    println(string)


    //DEC->HEX
    //72 → 0x48
    //101 → 0x65
    //108 → 0x6C
    //108 → 0x6C
    //111 → 0x6F
    val byteArrayHex = byteArrayOf(0x48.toByte(), 0x65.toByte(), 0x6C.toByte(), 0x6C.toByte(), 0x6F.toByte())
    val stringHex = String(byteArrayHex, Charsets.UTF_8)
    println(stringHex)
}