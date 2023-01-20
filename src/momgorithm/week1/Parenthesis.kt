package momgorithm.week1

/**
 * https://www.acmicpc.net/problem/9012
 */
private const val MATCH_VPS_ANSWER = "YES"
private const val NOT_MATCH_VPS_ANSWER = "NO"

fun main() {
    val count = readln().toInt()
    repeat(count) {
        val parenthesis = readln()
        println(isVPS(parenthesis))
    }
}

fun isVPS(parenthesis: String): String {
    val chars = parenthesis.split("")
    val queue = ArrayDeque<String>()
    chars.forEach {
        if (it == "(") {
            queue.addLast(it)
        }

        if (it == ")") {
            if (queue.isEmpty()) {
                return NOT_MATCH_VPS_ANSWER
            }
            queue.removeLast()
        }
    }
    if (queue.isNotEmpty()) {
        return NOT_MATCH_VPS_ANSWER
    }

    return MATCH_VPS_ANSWER
}