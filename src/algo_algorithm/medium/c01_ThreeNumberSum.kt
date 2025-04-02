package algo_algorithm.medium

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    array.sorted()
    val ans = mutableListOf<List<Int>>()
    for (i in 0 until array.size - 2) {
        var l = i + 1
        var r = array.size - 1
        while (l < r) {
            val sum = array[i] + array[l] + array[r]
            if (sum < targetSum) {
                l++
            } else if (sum > targetSum) {
                r--
            } else {
                ans.add(listOf(array[i], array[l], array[r]))
                l++
                r--
            }
        }
    }
    return ans
}