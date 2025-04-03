package algo_algorithm.medium

fun monotonicArray(array: List<Int>): Boolean {
    var isDown = false
    var j = 0
    for (i in 1 until array.size) {
        if (array[i] == array[i - 1]) continue
        isDown = array[i] < array[i - 1]
        j = i
        break
    }
    for (k in j until array.size) {
        if (isDown) {
            if (array[k] > array[k - 1]) {
                return false
            }
        } else {
            if (array[k] < array[k - 1]) {
                return false
            }
        }
    }
    return true
}

fun monotonicArray2(array: List<Int>): Boolean {
    var isNonDecreasing = true
    var isNonIncreasing = true
    for (i in 1 until array.size) {
        if (array[i] < array[i - 1]) isNonDecreasing = false
        if (array[i] > array[i - 1]) isNonIncreasing = false
    }
    return isNonDecreasing || isNonIncreasing
}

fun main() {
    val array = listOf(-1, -1, -5, -10, -1100, -1100, -1101, -1102, -9001)
    println(monotonicArray2(array))
}