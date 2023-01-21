package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10828
 *
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
private const val COMMAND_NAME_INDEX = 0
private const val COMMAND_VALUE_INDEX = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack()

    repeat (br.readLine().toInt()) {
        val command = br.readLine()
        val splitCommand = command.split(" ")
        when(splitCommand[COMMAND_NAME_INDEX]) {
            "push" -> stack.push(splitCommand[COMMAND_VALUE_INDEX].toInt())
            "pop" -> bw.write("${stack.pop()}\n")
            "size" -> bw.write("${stack.size()}\n")
            "empty" -> bw.write("${stack.empty()}\n")
            "top" -> bw.write("${stack.top()}\n")
        }
    }
    br.close()
    bw.flush()
    bw.close()
}

class Stack() {
    val stack: MutableList<Int> = mutableListOf()

    fun push(value: Int) {
        this.stack.add(value);
    }

    fun pop(): Int {
        if (this.stack.isEmpty()) {
            return INVALID_ACTION
        }
        val value = this.stack.removeLast()
        return value
    }

    fun size(): Int {
        return this.stack.size
    }

    fun empty(): Int {
        if (this.stack.isEmpty()) {
            return EMPTY_STATUS
        }
        return NOT_EMPTY_STATUS
    }

    fun top(): Int {
        if (this.stack.isEmpty()) {
            return INVALID_ACTION
        }
        return this.stack.last()
    }

    companion object {
        private const val INVALID_ACTION = -1
        private const val EMPTY_STATUS = 1
        private const val NOT_EMPTY_STATUS = 0
    }
}
