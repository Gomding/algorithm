package momgorithm.week1

/**
 * https://www.acmicpc.net/problem/11866
 */
fun main() {
    val josephusInfo = readln().split(" ")
    val totalCount = josephusInfo[0].toInt()
    val targetCount = josephusInfo[1].toInt()

    val circle = mutableListOf<Int>()
    repeat(totalCount) {
        circle.add(it + 1)
    }
    val removedResult = mutableListOf<Int>()
    var cursor = -1
    while (circle.isNotEmpty()) {
        cursor = (cursor + targetCount) % circle.size
        removedResult.add(circle.removeAt(cursor))
        cursor--
    }

    println(removedResult.joinToString(separator = ", ", prefix = "<", postfix = ">"))
}

class Josephus0 {
}