package momgorithm.week1

/**
 * https://www.acmicpc.net/problem/11050
 *
 * nCk
 */
fun main() {
    val input = readln().split(" ")
    val n = input[0].toLong()
    val k = input[1].toLong()

    println(factorial(n) / factorial(n - k) / factorial(k))
}

fun factorial(number: Long): Long {
    var result = 1L
    for (i in number downTo 2L) {
        result *= i
    }
    return result
}

class BinomialCoefficient {
}