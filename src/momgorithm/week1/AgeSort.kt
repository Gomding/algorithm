package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10814
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val memberCount = br.readLine().toInt()
    val members = mutableListOf<Member>()
    repeat(memberCount) {
        val memberInfo = br.readLine().split(" ")
        val age = memberInfo[0].toInt()
        val name = memberInfo[1]
        members.add(Member(age = age, name = name, joinOrder = it))
    }
    members.sorted().forEach { bw.write("${it.age} ${it.name}\n") }

    br.close()
    bw.flush()
    bw.close()
}

class Member(
    val age: Int,
    val name: String,
    val joinOrder: Int,
): Comparable<Member> {
    override fun compareTo(other: Member): Int {
        if (this.age > other.age) {
            return 1
        }
        if (this.age < other.age) {
            return -1
        }
        if (this.joinOrder > other.joinOrder) {
            return 1
        }
        if (this.joinOrder < other.joinOrder) {
            return -1
        }
        return 0
    }

}
