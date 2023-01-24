package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2751
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val repeatCount = br.readLine().toInt()
    val numbers = mutableListOf<Int>()

    repeat(repeatCount) {
        val number = br.readLine().toInt()
        numbers.add(number)
    }

    numbers.sort()
    numbers.forEach {
        bw.write("$it\n")
    }
    br.close()
    bw.flush()
    bw.close()
}
