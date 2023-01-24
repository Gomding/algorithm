package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

/**
 * https://www.acmicpc.net/problem/2798
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val roundInfo = br.readLine().split(" ")
    val cardCount = roundInfo[0].toInt()
    val targetScore = roundInfo[1].toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }

    var result: Int = 0
    for(first in 1..cardCount - 3) {
        val firstCard = cards[first]
        if (firstCard > targetScore) {
            return
        }
        for (second in (first + 1)..cardCount - 2) {
            val secondCard = cards[second]
            if (firstCard + secondCard > targetScore) {
                continue
            }
            for (third in (second + 1)..cardCount - 1) {
                val thirdCard = cards[third]
                if (firstCard + secondCard + thirdCard > targetScore) {
                    continue
                }
                result = max(result, firstCard + secondCard + thirdCard)
            }
        }
    }

    println(result)
}

class BlackJack {

}