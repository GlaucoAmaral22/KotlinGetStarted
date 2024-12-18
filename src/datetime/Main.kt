package datetime

import java.time.Instant.now
import java.time.Instant
import java.time.Period
import java.time.ZoneId

fun main() {
    val instant: Instant = now()
    println(instant.plus(Period.ofDays(5)))

    println(now().atZone(ZoneId.of("America/Sao_Paulo")))
}