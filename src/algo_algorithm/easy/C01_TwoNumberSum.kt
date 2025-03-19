package algo_algorithm.easy

// 两数之和
fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    array.sort()
    var left = 0
    var right = array.size - 1
    while (left < right) {
        val currentSum = array[left] + array[right]
        if (currentSum == targetSum) {
            return listOf<Int>(array[left], array[right])
        } else if (currentSum < targetSum) {
            left++
        } else if (currentSum > targetSum) {
            right--
        }
    }
    return listOf<Int>()
}