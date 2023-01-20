package momgorithm.week1

/**
 * https://www.acmicpc.net/problem/1978
 */

private const val MAX_NUMBER = 1000

fun main() {
    val size = readln()
    val numbersString = readln()
    val numbers: List<Int> = numbersString.split(" ").map { it.toInt() }
    val count = solution(numbers)
    print(count)
}

private fun solution(numbers: List<Int>): Int {
    val primeNumberTable = primeNumberTable(MAX_NUMBER)
    return numbers.count {
        primeNumberTable[it] != 0
    }
}

private fun primeNumberTable(destination: Int): List<Int> {
    val numberTable = numberTable(destination)
    val primeNumberTable = deleteCompositeNumbers(numberTable, destination)
    return primeNumberTable
}

private fun deleteCompositeNumbers(numberTable: MutableList<Int>, destination: Int): List<Int> {
    val primeNumberTable = numberTable.toMutableList()
    primeNumberTable[1] = 0
    for (i in 2..destination) {
        if (primeNumberTable[i] == 0) {
            continue
        }

        for (j in (i * 2)..destination step i) {
            primeNumberTable[j] = 0
        }
    }
    return primeNumberTable
}

private fun numberTable(destination: Int): MutableList<Int> {
    val numberTable = mutableListOf<Int>()
    for (i in 0..destination) {
        numberTable.add(i)
    }
    return numberTable
}