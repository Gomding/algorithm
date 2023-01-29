package momgorithm.week1

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/10816
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val handCardCount = br.readLine()
    val handCards = br.readLine().split(" ").map { it.toInt() }
    val targetNumberCount = br.readLine()
    val targetNumbers = br.readLine().split(" ").map { it.toInt() }

    val numbersCountInfo = mutableMapOf<Int, Int>()
    handCards.forEach {
        numbersCountInfo.merge(it, 1) { oldVal,value -> oldVal + value }
    }

    val resultCount = mutableListOf<Int>()
    targetNumbers.forEach {
        resultCount.add(numbersCountInfo[it]?: 0)
    }
    println(resultCount.joinToString(separator = " "))

    br.close()
}

class NumberCard2 {
}