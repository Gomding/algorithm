package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11650
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val repeatCount = br.readLine().toInt()
    val coordinates = mutableListOf<Coordinate>()
    repeat(repeatCount) {
        val coordinateInfo = br.readLine().split(" ").map { it.toInt() }
        val x = coordinateInfo[0]
        val y = coordinateInfo[1]
        coordinates.add(Coordinate(x, y))
    }
    coordinates.sorted().forEach { bw.write("${it.x} ${it.y}\n") }

    br.close()
    bw.flush()
    bw.close()
}

class Coordinate (
    val x: Int,
    val y: Int
): Comparable<Coordinate> {
    override fun compareTo(other: Coordinate): Int {
        if (this.x > other.x) {
            return 1
        }
        if (this.x < other.x) {
            return -1
        }
        if (this.y > other.y) {
            return 1
        }
        if (this.y < other.y) {
            return -1
        }
        return 0
    }
}