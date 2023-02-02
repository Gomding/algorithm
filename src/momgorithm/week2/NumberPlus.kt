package momgorithm.week2

import java.io.BufferedReader
import java.io.BufferedWriter

/**
 * https://www.acmicpc.net/problem/9095
 */
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    solve(br, bw)
    bw.flush()
    bw.close()
}

private fun solve(br: BufferedReader, bw: BufferedWriter) {
    val count = readInt(br)
    val numbers = mutableListOf<Int>()
    repeat(count) {
        numbers.add(readInt(br))
    }

    val results = mutableListOf<Int>()
    results.add(0)
    results.add(1)
    results.add(2)
    results.add(4)
    results.add(7)
    val maxNumber = numbers.max()
    for (i in 5..maxNumber) {
        results.add(results[i - 1] + results[i - 2] + results[i - 3])
    }

    numbers.forEach {
        bw.write("${results[it]}\n")
    }
}

private fun readInt(br: BufferedReader) = br.readLine().toInt()

private fun readList(br: BufferedReader) =
        br.readLine().split(" ").map { it.toInt() }


// 2 -> 1 + 1 -> 2
// 3 -> 1 + 1 + 1 / 2 + 1 / 1 + 2 -> 4
// 4 -> 1 + 1 + 1 + 1 / 2 + 1 + 1 / 1 + 2 + 1 / 1 + 1 + 2 / 2 + 2 / 3 + 1 / 1 + 3 -> 7
// 5 -> 2 + 3 / 4 + 1 / 1 + 4 -> 13
// 6 -> 1 + 5 / 2 + 4 / 3 + 3 -> 24
// 7 -> 1 + 6 / 2 + 5 / 3 + 4 -> 44