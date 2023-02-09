package momgorithm.week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/2606
 */
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    solve(br, bw)
    bw.flush()
    bw.close()
}

private fun solve(br: BufferedReader, bw: BufferedWriter) {
    val computerCount = readInt(br)
    val linkedCount = readInt(br)
    val computerComputer = MutableList(computerCount + 1) { Computer(it) }
    repeat(linkedCount) {
        val (a, b) = readList(br)
        computerComputer[a].addNode(computerComputer[b])
        computerComputer[b].addNode(computerComputer[a])
    }

    val queue = LinkedList<Computer>()
    val visited = MutableList(computerCount + 1) { false }
    queue.add(computerComputer[1])
    visited[1] = true
    var resultCount = 0
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val currentComputer = queue.poll()
            currentComputer.linkedInfo.forEach {
                if (visited[it.computeNumber] == false) {
                    visited[it.computeNumber] = true
                    queue.add(it)
                    resultCount++
                }
            }
        }
    }
    bw.write("$resultCount")
}

data class Computer(
    val computeNumber: Int,
    val linkedInfo: MutableList<Computer> = mutableListOf()
) {

    fun addNode(value: Computer) {
        this.linkedInfo.add(value)
    }
}

private fun readInt(br: BufferedReader) = br.readLine().toInt()

private fun readList(br: BufferedReader) =
        br.readLine().split(" ").map { it.toInt() }

class WormVirus {
}