import java.io.BufferedReader
import java.io.BufferedWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/1260
 */
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    solve(br, bw)

    bw.flush()
    bw.close()
}

private fun solve(br: BufferedReader, bw: BufferedWriter) {
    // 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V
    val (N, M, V) = readList(br)
    val map = mutableMapOf<Int, Node>()
    for (i in 1..N) {
        map[i] = Node(i)
    }
    repeat(M) {
        val (root, child) = readList(br)
        map[root]?.addNode(child)
        map[child]?.addNode(root)
    }

    printDfs(bw, N, V, map)
    printBfs(bw, N, V, map)
}

private fun printDfs(bw: BufferedWriter, N: Int, V: Int, map: MutableMap<Int, Node>) {
    val visited = MutableList(N + 1) { false }
    val result = mutableListOf<Int>()

    visited[V] = true
    result.add(V)
    dfs(map, V, result, visited)
    bw.write(result.joinToString(separator = " ") + "\n")
}

private fun dfs(map: MutableMap<Int, Node>, root: Int, result: MutableList<Int>, visited: MutableList<Boolean>) {
    map[root]?.nodes?.forEach {
        if (!visited[it]) {
            visited[it] = true
            result.add(it)
            dfs(map, it, result, visited)
        }
    }
}

fun printBfs(bw: BufferedWriter, N: Int, V: Int, map: MutableMap<Int, Node>) {
    val queue = LinkedList<Int>()
    val visited = MutableList(N + 1) { false }
    val result = mutableListOf<Int>()

    bfs(queue, V, visited, result, map)

    bw.write(result.joinToString(separator = " ") + "\n")
}

private fun bfs(
    queue: LinkedList<Int>,
    start: Int,
    visited: MutableList<Boolean>,
    result: MutableList<Int>,
    map: MutableMap<Int, Node>
) {
    queue.add(start)
    visited[start] = true

    while (queue.size != 0) {
        val value = queue.poll()
        result.add(value)
        map[value]?.nodes?.forEach { visitPoint ->
            if (!visited[visitPoint]) {
                queue.add(visitPoint)
                visited[visitPoint] = true
            }
        }
    }
}

private fun readInt(br: BufferedReader) = br.readLine().toInt()

private fun readList(br: BufferedReader) =
        br.readLine().split(" ").map { it.toInt() }

class Node(
    val value: Int,
) {
    val nodes: MutableList<Int> = mutableListOf()

    fun addNode(value: Int) {
        this.nodes.add(value)
        this.nodes.sort()
    }
}
