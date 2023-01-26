package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1920
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val numbersCount = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }
    val targetNumberCount = br.readLine().toInt()
    val targetNumbers = br.readLine().split(" ").map { it.toInt() }

    val sortedNumbers = numbers.sorted()
    targetNumbers.forEach { targetNumber ->
        if (searchNumber(sortedNumbers, targetNumber)) {
            bw.write("1\n")
        } else {
            bw.write("0\n")
        }
    }

    br.close()
    bw.flush()
    bw.close()
}

fun searchNumber(numbers: List<Int>, targetNumber: Int): Boolean {
    if (numbers.size == 1) {
        return numbers[0] == targetNumber
    }
    val mid = numbers.size / 2
    return if (targetNumber >= numbers[mid]) {
        searchNumber(numbers.subList(mid, numbers.size), targetNumber)
    } else {
        searchNumber(numbers.subList(0, mid), targetNumber)
    }
}
