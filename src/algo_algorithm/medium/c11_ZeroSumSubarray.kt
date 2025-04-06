package algo_algorithm.medium

fun zeroSumSubarray(nums: List<Int>): Boolean {
    val sums = mutableSetOf(0)
    var currentSum = 0
    for (num in nums) {
        currentSum += num
        if (currentSum in sums) return true
        sums.add(currentSum)
    }
    return false
}

fun main() {
    val nums = listOf(4, -3, 2, 4, -1, -5, 7)
    println(zeroSumSubarray(nums))
}