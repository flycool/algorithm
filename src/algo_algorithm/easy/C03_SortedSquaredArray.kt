package algo_algorithm.easy

import kotlin.math.abs

class C03_SortedSquaredArray {

    fun sortedSquaredArray(arr: List<Int>): List<Int> {
        val sortedSquares = arr.map { _ -> 0 }.toMutableList()
        var start = 0
        var end = arr.size - 1

        for (i in arr.size - 1 downTo 0) {
            val smallValue = arr[start]
            val largeValue = arr[end]
            if (abs(smallValue) > abs(largeValue)) {
                sortedSquares.add(i, smallValue * smallValue)
                start++
            } else {
                sortedSquares.add(i, largeValue * largeValue)
                end--
            }
        }
        return sortedSquares
    }
}