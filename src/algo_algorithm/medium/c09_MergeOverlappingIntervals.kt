package algo_algorithm.medium

import kotlin.math.max

fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    var sortedIntervals = intervals.toMutableList().sortedWith(
        Comparator<List<Int>> { a, b -> a[0].compareTo(b[0]) }
    ).map { it -> it.toMutableList() }

    val mergedIntervals = mutableListOf<MutableList<Int>>()
    var currentInterval = sortedIntervals[0]
    mergedIntervals.add(currentInterval)

    for (nextInterval in sortedIntervals) {
        val (curIntervalStart, curIntervalEnd) = currentInterval
        val (nextIntervalStart, nextIntervalEnd) = nextInterval

        if (curIntervalEnd >= nextIntervalStart) {
            currentInterval[1] = max(curIntervalEnd, nextIntervalEnd)
        } else {
            currentInterval = nextInterval
            mergedIntervals.add(currentInterval)
        }
    }
    return mergedIntervals
}

fun main() {
    val array = listOf(
        listOf(1, 2),
        listOf(3, 5),
        listOf(4, 7),
        listOf(6, 8),
        listOf(9, 10),
    )
    println(mergeOverlappingIntervals(array))
}