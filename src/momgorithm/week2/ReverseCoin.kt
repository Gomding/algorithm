package momgorithm.week2

import java.io.BufferedReader
import java.io.BufferedWriter

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    solve(br, bw)
    bw.flush()
    bw.close()
}

private fun solve(br: BufferedReader, bw: BufferedWriter) {
    val (coinCount, targetValue) = readList(br)
    val coins = mutableListOf<Int>()
    repeat(coinCount) {
        coins.add(readInt(br))
    }
    coins.reverse()

    var targetVal = targetValue
    var result = 0
    coins.forEach {
        if (targetVal / it != 0) {
            result += targetVal / it
            targetVal = (targetVal % it)
        }
    }
    bw.write("$result")
}

private fun readInt(br: BufferedReader) = br.readLine().toInt()

private fun readList(br: BufferedReader) =
        br.readLine().split(" ").map { it.toInt() }
