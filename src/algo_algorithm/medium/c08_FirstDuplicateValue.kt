package algo_algorithm.medium

import kotlin.math.abs

fun firstDuplicateValue(array: MutableList<Int>): Int {
    val set = hashSetOf<Int>()
    for (value in array) {
        if (value in set) return value
        set.add(value)
    }
    return -1
}

// array 里的正数 都在 1..n 里，n为数组长度
fun firstDuplicateValue2(array: MutableList<Int>): Int {
    for (value in array) {
        val absValue = abs(value)
        if (array[absValue - 1] < 0) return absValue
        array[absValue - 1] *= -1
    }
    return -1
}

fun main() {
    val array = mutableListOf(2, 1, 5, 2, 3, 3, 4)
    println(firstDuplicateValue2(array))
}