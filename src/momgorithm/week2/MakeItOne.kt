package momgorithm.week2

import kotlin.math.min

/**
 * https://www.acmicpc.net/problem/1463
 */
fun main() {
    val targetNumber = readln().toInt()

    val cache = MutableList(targetNumber + 1) { 0 }

    if (targetNumber >= 2) cache[2] = 1
    if (targetNumber >= 3) cache[3] = 1

    IntRange(4, targetNumber).forEach {
        val calcValue = calcStep(it, cache)
        cache[it] = calcValue
    }

    println(cache[targetNumber])
}

fun calcStep(value: Int, cache: List<Int>): Int {
    val minusFromOne = value - 1
    var divFromTwo = minusFromOne
    var divFromThree = minusFromOne
    if (value % 2 == 0) {
        divFromTwo = value / 2
    }
    if (value % 3 == 0) {
        divFromThree = value / 3
    }

    return min(cache[divFromTwo], min(cache[divFromThree], cache[minusFromOne])) + 1
}
