package algo_algorithm.medium

fun bestSeat(array: MutableList<Int>): Int {
    var bestSeat = -1
    var maxSpace = 0
    var l = 0
    while (l < array.size) {
        var r = l + 1
        while (r < array.size && array[r] == 0) {
            r++
        }

        val availableSpace = r - l - 1
        if (availableSpace > maxSpace) {
            bestSeat = (l + r) / 2
            maxSpace = availableSpace
        }
        l = r
    }
    return bestSeat
}

fun main() {
    val array = mutableListOf(1, 0, 1, 0, 0, 0, 1)
    println(bestSeat(array))
}