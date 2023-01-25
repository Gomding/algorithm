package momgorithm.week1

import kotlin.math.max
import kotlin.math.min

/**
 * https://www.acmicpc.net/problem/2609
 *
 * 유클리드 호제법 - https://myjamong.tistory.com/138
 */
fun main() {
    val numbers = readln().split(" ")
    val a = numbers[0].toInt()
    val b = numbers[1].toInt()

    val greatestCommonDivisor = greatestCommonDivisor(a, b)
    println(greatestCommonDivisor)
    println(leastCommonMultiple(a, b, greatestCommonDivisor))
}

fun greatestCommonDivisor(number1: Int, number2: Int): Int {
    val result = max(number1, number2) % min(number1, number2)
    if (result == 0) {
        return min(number1, number2)
    }
    return greatestCommonDivisor(
        number1 = min(number1, number2),
        number2 = result
    )
}

fun leastCommonMultiple(number1: Int, number2: Int, greatestCommonDivisor: Int): Int {
    return (number1 * number2) / greatestCommonDivisor
}

class GcdAndLcm {

}