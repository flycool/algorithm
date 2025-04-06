package algo_algorithm.medium

fun majorityElement(nums: List<Int>): Int {
    var ans = nums[0]
    var count = 0
    for (value in nums) {
        if (count == 0) ans = value

        if (value == ans) {
            count++
        } else {
            count--
        }
    }
    return ans
}

fun majorityElement2(array: List<Int>): Int {
    var ans = 0
    for (currentBit in 0 until 32) {
        val currentBitValue = 1 shl currentBit
        // how many bitset in the array
        var onesCount = 0

        for (num in array) {
            if ((num and currentBitValue) != 0) onesCount++
        }

        if (onesCount > array.size / 2) ans += currentBitValue
    }
    return ans
}

fun main() {
    val nums = listOf(1, 1, 2, 2, 7, 2, 2)
    println(majorityElement2(nums))
}