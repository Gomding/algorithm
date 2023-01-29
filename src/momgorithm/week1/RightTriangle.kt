package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

/**
 * https://www.acmicpc.net/problem/4153
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var line = br.readLine()

    while (line != "0 0 0") {
        val triangleInfo = line.split(" ")
        val triangle = Triangle(triangleInfo[0].toInt(), triangleInfo[1].toInt(), triangleInfo[2].toInt())
        if (triangle.isRightTriangle()) {
            bw.write("right\n")
        } else {
            bw.write("wrong\n")
        }

        line = br.readLine()
    }

    br.close()
    bw.flush()
    bw.close()
}

class Triangle(
    val a: Int,
    val b: Int,
    val c: Int,
) {
    fun isRightTriangle(): Boolean {
        return when(max(a, max(b, c))) {
            a -> a.times(a) == b.times(b) + c.times(c)
            b -> b.times(b) == a.times(a) + c.times(c)
            else -> { c.times(c) == a.times(a) + b.times(b) }
        }
    }
}