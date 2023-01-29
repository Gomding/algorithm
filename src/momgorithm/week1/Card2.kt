package momgorithm.week1

/**
 * https://www.acmicpc.net/problem/2164
 */
fun main() {
    val cardCount = readln().toInt()

    val cardDeque = ArrayDeque<Int>()
    for (cardNumber in cardCount downTo 1) {
        cardDeque.add(cardNumber)
    }
    while (cardDeque.size > 1) {
        cardDeque.removeLast()
        cardDeque.addFirst(cardDeque.removeLast())
    }
    println(cardDeque[0])
}

class Card2 {
}