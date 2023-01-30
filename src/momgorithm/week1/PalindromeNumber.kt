package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1259
 */
private const val FINISH_NUMBER = "0"

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var targetNumber = br.readLine()

    while(targetNumber != FINISH_NUMBER) {
        val reversedTargetNumber = targetNumber.reversed()
        if (targetNumber == reversedTargetNumber) {
            bw.write("yes\n")
        } else {
            bw.write("no\n")
        }
        targetNumber = br.readLine()
    }

    br.close()
    bw.flush()
    bw.close()
}

class PalindromeNumber {
}