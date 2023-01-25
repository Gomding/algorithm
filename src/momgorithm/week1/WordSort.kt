package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1181
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val repeatCount = br.readLine().toInt()
    val words = mutableSetOf<String>()
    repeat(repeatCount) {
        words.add(br.readLine())
    }
    val sortedWords: List<String> = sortWords(words)
    sortedWords.forEach { bw.write("$it\n") }

    br.close()
    bw.flush()
    bw.close()
}

fun sortWords(words: Set<String>): List<String> {
    val wordMap: Map<Int, List<String>> = words.groupBy { it.length }.toSortedMap()
    return wordMap.flatMap { it.value.sorted() }
}

class WordSort {
}