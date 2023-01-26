package momgorithm.week1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/**
 * https://www.acmicpc.net/problem/1018
 */
private const val CHESS_BOARD_SIZE = 8
private val START_WHITE_LINE = "WBWBWBWB".toList().map { it.toString() }
private val START_BLACK_LINE = "BWBWBWBW".toList().map { it.toString() }

private val START_WHITE_BOARD = listOf(
    START_WHITE_LINE,
    START_BLACK_LINE,
    START_WHITE_LINE,
    START_BLACK_LINE,
    START_WHITE_LINE,
    START_BLACK_LINE,
    START_WHITE_LINE,
    START_BLACK_LINE,
)

private val START_BLACK_BOARD = listOf(
    START_BLACK_LINE,
    START_WHITE_LINE,
    START_BLACK_LINE,
    START_WHITE_LINE,
    START_BLACK_LINE,
    START_WHITE_LINE,
    START_BLACK_LINE,
    START_WHITE_LINE,
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val boardInfo = br.readLine().split(" ")
    val boardHeight = boardInfo[0].toInt()
    val boardWidth = boardInfo[1].toInt()
    val board = mutableListOf<List<String>>()

    repeat(boardHeight) {
        board.add(br.readLine().toList().map { it.toString() })
    }

    val coloringLeastCount = coloringLeastCount(board.toList())

    println(coloringLeastCount)
    br.close()
}

fun coloringLeastCount(board: List<List<String>>): Int {
    var leastCount = Int.MAX_VALUE
    val heightMaxIndex = board.size - 1
    val widthMaxIndex = board.first().size - 1
    for (i in 0..heightMaxIndex - CHESS_BOARD_SIZE + 1) {
        val cutHeightBoard = board.subList(i, i + CHESS_BOARD_SIZE)
        for (j in 0..widthMaxIndex - CHESS_BOARD_SIZE + 1) {
            val cutBoard = cutHeightBoard.map { it.subList(j, j + CHESS_BOARD_SIZE) }
            leastCount = min(coloringCount(cutBoard, START_WHITE_BOARD), leastCount)
            leastCount = min(coloringCount(cutBoard, START_BLACK_BOARD), leastCount)
        }
    }
    return leastCount
}

fun coloringCount(board: List<List<String>>, targetBoard: List<List<String>>): Int {
    // board 와 체스 보드 비교하여 교체해야하는 숫자 반환
    val coloringCount = board.zip(targetBoard).sumOf { (boardLine, targetBoardLine) ->
        boardLine.zip(targetBoardLine).count { (a, b) ->
            a != b
        }
    }
    return coloringCount
}

class ChessboardColoring {

}