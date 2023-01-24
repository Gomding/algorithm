package momgorithm.week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10250
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val repeatCount = br.readLine().toInt()
    repeat(repeatCount) {
        val hotelAndGuestInfo = br.readLine().split(" ")
        val hotelHeight = hotelAndGuestInfo[0].toInt()
        val hotelWidth = hotelAndGuestInfo[1].toInt()
        val guestNumber = hotelAndGuestInfo[2].toInt()

        val assignedRoom = assignRoom(hotelHeight = hotelHeight, hotelWidth = hotelWidth, guestNumber = guestNumber)
        bw.write("$assignedRoom\n")
    }

    br.close()
    bw.flush()
    bw.close()
}

fun assignRoom(
    hotelHeight: Int,
    hotelWidth: Int,
    guestNumber: Int
): String {
    val guestHeight = when (guestNumber % hotelHeight) {
        0 -> hotelHeight
        else -> guestNumber % hotelHeight
    }
    val guestWidth = when (guestNumber % hotelHeight) {
        0 -> guestNumber / hotelHeight
        else -> (guestNumber / hotelHeight) + 1
    }

    val guestHeightString = guestHeight.toString()
    val guestWidthString = if (guestWidth < 10) "0$guestWidth" else guestWidth.toString()

    return guestHeightString + guestWidthString
}

/**
 * 2
 * 6 12 6
 * 30 50 30
 * 602
 * 3002
 */