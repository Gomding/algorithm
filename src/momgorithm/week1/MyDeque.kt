package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10866
 */
private const val COMMAND_NAME_INDEX = 0
private const val COMMAND_VALUE_INDEX = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val deque = MyDeque()

    repeat(br.readLine().toInt()) {
        val command = br.readLine()
        val splitCommand = command.split(" ")
        when (splitCommand[COMMAND_NAME_INDEX]) {
            "push_front" -> deque.pushFront(splitCommand[COMMAND_VALUE_INDEX].toInt())
            "push_back" -> deque.pushBack(splitCommand[COMMAND_VALUE_INDEX].toInt())
            "pop_front" -> bw.write("${deque.popFront()}\n")
            "pop_back" -> bw.write("${deque.popBack()}\n")
            "size" -> bw.write("${deque.size()}\n")
            "empty" -> bw.write("${deque.empty()}\n")
            "front" -> bw.write("${deque.front()}\n")
            "back" -> bw.write("${deque.back()}\n")
        }
    }
    br.close()
    bw.flush()
    bw.close()
}

/**
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
class MyDeque {
    private val values = mutableListOf<Int>()

    fun pushFront(value: Int) {
        this.values.add(0, value)
    }

    fun pushBack(value: Int) {
        this.values.add(value)
    }

    fun popFront(): Int {
        if (this.values.isEmpty()) {
            return -1
        }
        return this.values.removeFirst()
    }

    fun popBack(): Int {
        if (this.values.isEmpty()) {
            return -1
        }
        return this.values.removeLast()
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
