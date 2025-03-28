package algo_algorithm.easy

import kotlin.math.min

fun optimalFreeLancing(jobs: MutableList<Map<String, Int>>): Int {
    val LENGTH_OF_WEEK = 7
    var profit = 0
    jobs.sortWith(
        Comparator<Map<String, Int>> { jobA, jobB ->
            jobB["payment"]!!.compareTo(jobA["payment"]!!)
        }
    )
    val timeline = MutableList(LENGTH_OF_WEEK) { false }
    for (job in jobs) {
        val maxTime = min(job["deadline"]!!, LENGTH_OF_WEEK)
        for (time in maxTime - 1 downTo 0) {
            if (timeline[time] == false) {
                timeline[time] = true
                profit += job["payment"]!!
                break;
            }
        }
    }
    return profit
}