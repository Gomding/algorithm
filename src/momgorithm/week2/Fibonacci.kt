package momgorithm.week2

import java.io.BufferedReader
import java.io.BufferedWriter

/**
 * https://www.acmicpc.net/problem/1003
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

    val cache = mutableListOf<FibonacciInfo>()
    cache.add(FibonacciInfo(1, 0))
    cache.add(FibonacciInfo(0, 1))
    IntRange(2, numbers.max()).forEach {
        cache.add(cache[it - 1] + cache[it - 2])
    }

    numbers.forEach {
        bw.write("${cache[it].zeroCount} ${cache[it].oneCount}\n")
    }
}

data class FibonacciInfo(
    val zeroCount: Int,
    val oneCount: Int,
) {
    operator fun plus(other: FibonacciInfo) = FibonacciInfo(zeroCount + other.zeroCount, oneCount + other.oneCount)
}

private fun readInt(br: BufferedReader) = br.readLine().toInt()

private fun readList(br: BufferedReader) =
        br.readLine().split(" ").map { it.toInt() }
