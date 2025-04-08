package algo_algorithm.medium

import kotlin.math.min

fun ninNumberOfCoinsForChange(n: Int, denoms: List<Int>): Int {
    val nums = MutableList(n + 1) { Int.MAX_VALUE }
    nums[0] = 0
    var toCompare: Int
    for (denom in denoms) {
        for (amount in 0..n) {
            if (denom <= amount) {
                if (nums[amount - denom] == Int.MAX_VALUE) {
                    toCompare = nums[amount - denom]
                } else {
                    toCompare = nums[amount - denom] + 1
                }
                nums[amount] = min(nums[amount], toCompare)
            }
        }
    }
    return if (nums[n] != Int.MAX_VALUE) nums[n] else -1
}

fun main() {
    val denoms = listOf(1, 2, 4)
    println(ninNumberOfCoinsForChange(6, denoms))
}