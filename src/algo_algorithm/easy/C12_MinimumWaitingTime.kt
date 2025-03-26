package algo_algorithm.easy

fun minimumWaitingTime(array: MutableList<Int>): Int {
    array.sorted()
    val n = array.size
    var total = 0
    for (i in 0 until n) {
        total += array[i] * (n - i + 1)
    }
    return total
}