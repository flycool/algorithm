package algo_algorithm.medium

import kotlin.math.max

fun maxSubsetSumNoAdjacent(array: MutableList<Int>): Int {
    val maxSums = array.toMutableList()
    maxSums[1] = max(array[0], array[1])

    for (i in 2 until array.size) {
        maxSums[i] = max(maxSums[i - 1], maxSums[i - 2] + array[i])
    }
    return maxSums[array.size - 1]
}

fun maxSubsetSumNoAdjacent2(array: MutableList<Int>): Int {
    var second = array[0]
    var first = max(array[0], array[1])
    for (i in 2 until array.size) {
        val current = max(first, second + array[i])
        second = first
        first = current
    }
    return first
}

fun main() {
    val array = mutableListOf(7, 10, 12, 7, 9, 14)
    println(maxSubsetSumNoAdjacent(array))
}