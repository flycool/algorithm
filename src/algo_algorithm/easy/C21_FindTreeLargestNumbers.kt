package algo_algorithm.easy

fun findTreeLargestNumbers(array: List<Int>): List<Int> {
    val ans = MutableList(3) { Int.MIN_VALUE }
    for (num in array) {
        updateLargest(ans, num)
    }
    return ans
}

fun updateLargest(ans: MutableList<Int>, num: Int) {
    if (num > ans[2]) {
        shiftAndUpate(ans, num, 2)
    } else if (num > ans[1]) {
        shiftAndUpate(ans, num, 1)
    } else if (num > ans[0]) {
        shiftAndUpate(ans, num, 0)
    }
}

fun shiftAndUpate(array: MutableList<Int>, num: Int, idx: Int) {
    for (i in 0 until idx + 1) {
        if (i == idx) {
            array[i] = num
        } else {
            array[i] = array[i + 1]
        }
    }
}