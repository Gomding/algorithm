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
    val count = br.readLine().toInt()
    val times = readList(br)
    val sortedTimes = times.toMutableList().sorted()

    var waitingTime = 0
    var result = mutableListOf<Int>()
    sortedTimes.forEach {
        waitingTime += it
        result.add(waitingTime)
    }
    bw.write("${result.sum()}")
}

private fun readInt(br: BufferedReader) = br.readLine().toInt()

private fun readList(br: BufferedReader) =
        br.readLine().split(" ").map { it.toInt() }