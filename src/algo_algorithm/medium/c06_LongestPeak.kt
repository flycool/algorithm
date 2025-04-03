package algo_algorithm.medium

import kotlin.math.max

fun longestPeak(array: List<Int>): Int {
    var ans = 0
    for (i in 1 until array.size - 1) {
        if ((array[i] > array[i - 1]) && (array[i] > array[i + 1])) {
            ans = max(ans, caculatePeakLength(array, i))
        }
    }
    return ans
}

private fun caculatePeakLength(array: List<Int>, peakIndex: Int): Int {
    var l = peakIndex
    var r = peakIndex
    var len = array.size - 1
    while (l > 0 && r < len) {
        while (array[l] > array[l - 1]) {
            l--
        }
        while (array[r] > array[r + 1]) {
            r++
        }
        break
    }
    return r - l + 1
}

fun main() {
    val array = listOf(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3)
    val ans = longestPeak(array)
    println(ans)
}