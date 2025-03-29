package algo_algorithm.easy

// time : O(n) | space: O(d) d: 数组的深度
fun productSum(array: List<*>): Int {
    return productSumHelper(array, 1)
}

private fun productSumHelper(array: List<*>, m: Int): Int {
    var sum = 0
    for (el in array) {
        if (el is List<*>) {
            sum += productSumHelper(el, m + 1)
        } else {
            sum += el as Int
        }
    }
    return sum * m
}