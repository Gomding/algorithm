package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10845
 */
private const val COMMAND_NAME_INDEX = 0
private const val COMMAND_VALUE_INDEX = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val queue = MyQueue()

    repeat(br.readLine().toInt()) {
        val command = br.readLine()
        val splitCommand = command.split(" ")
        when (splitCommand[COMMAND_NAME_INDEX]) {
            "push" -> queue.push(splitCommand[COMMAND_VALUE_INDEX].toInt())
            "pop" -> bw.write("${queue.pop()}\n")
            "size" -> bw.write("${queue.size()}\n")
            "empty" -> bw.write("${queue.empty()}\n")
            "front" -> bw.write("${queue.front()}\n")
            "back" -> bw.write("${queue.back()}\n")
        }
    }
    br.close()
    bw.flush()
    bw.close()
}

/**
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
class MyQueue {
    private val values = mutableListOf<Int>()

    fun push(value: Int) {
        this.values.add(value)
    }

    fun pop(): Int {
        if (this.values.isEmpty()) {
            return -1
        }
        return this.values.removeFirst()
    }

    fun size(): Int {
        return this.values.size
    }

    fun empty(): Int {
        if (this.values.isEmpty()) {
            return 1
        }
        return 0
    }

    fun front(): Int {
        if (this.values.isEmpty()) {
            return -1
        }
        return this.values.first()
    }

    fun back(): Int {
        if (this.values.isEmpty()) {
            return -1
        }
        return this.values.last()
    }
}