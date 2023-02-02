package momgorithm.week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.util.LinkedList

/**
 * https://www.acmicpc.net/problem/2178
 */
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    solve(br, bw)
    bw.flush()
    bw.close()
}

private fun solve(br: BufferedReader, bw: BufferedWriter) {
    // N x M 미로 / N = height, M = width
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val maze = mutableListOf<List<Int>>()
    repeat(N) {
        maze.add(readList(br))
    }

    var moveCount = 0
    var resultCount = 0
    val visited = MutableList(N) { MutableList(M) { false } }
    val queue = LinkedList<Square>()
    queue.add(Square(pointX = 0, pointY = 0))
    visited[0][0] = true
    while (queue.isNotEmpty()) {
        moveCount++
        repeat(queue.size) {
            val currentSquare = queue.poll()
            if (canMoveRight(currentSquare, M) && maze[currentSquare.pointY][currentSquare.pointX + 1] == 1 && visited[currentSquare.pointY][currentSquare.pointX + 1] == false) {
                visited[currentSquare.pointY][currentSquare.pointX + 1] = true
                queue.add(Square(pointX = currentSquare.pointX + 1, pointY = currentSquare.pointY))
            }
            if (canMoveLeft(currentSquare) && maze[currentSquare.pointY][currentSquare.pointX - 1] == 1 && visited[currentSquare.pointY][currentSquare.pointX - 1] == false) {
                visited[currentSquare.pointY][currentSquare.pointX - 1] = true
                queue.add(Square(pointX = currentSquare.pointX - 1, pointY = currentSquare.pointY))
            }
            if (canMoveUp(currentSquare, N) && maze[currentSquare.pointY + 1][currentSquare.pointX] == 1 && visited[currentSquare.pointY + 1][currentSquare.pointX] == false) {
                visited[currentSquare.pointY + 1][currentSquare.pointX] = true
                queue.add(Square(pointX = currentSquare.pointX, pointY = currentSquare.pointY + 1))
            }
            if (canMoveDown(currentSquare) && maze[currentSquare.pointY - 1][currentSquare.pointX] == 1 && visited[currentSquare.pointY - 1][currentSquare.pointX] == false) {
                visited[currentSquare.pointY - 1][currentSquare.pointX] = true
                queue.add(Square(pointX = currentSquare.pointX, pointY = currentSquare.pointY - 1))
            }
            if (currentSquare == Square(pointX = M - 1, pointY = N - 1)) {
                resultCount = moveCount
            }
        }
    }
    bw.write("$resultCount")
}

private fun canMoveDown(currentSquare: Square) = currentSquare.pointY - 1 >= 0

private fun canMoveUp(currentSquare: Square, N: Int) = currentSquare.pointY + 1 < N

private fun canMoveLeft(currentSquare: Square) = currentSquare.pointX - 1 >= 0

private fun canMoveRight(currentSquare: Square, M: Int) = currentSquare.pointX + 1 < M

data class Square(
    val pointX: Int,
    val pointY: Int,
)

private fun readInt(br: BufferedReader) = br.readLine().toInt()

private fun readList(br: BufferedReader) =
    br.readLine().toList().map { it.toString() }.map { it.toInt() }
