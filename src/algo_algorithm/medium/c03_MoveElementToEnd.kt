package algo_algorithm.medium

fun moveElementToEnd(array: MutableList<Int>, target: Int): List<Int> {
    var l = 0
    var r = array.size - 1
    while (l < r) {
        var left = array[l]
        var right = array[r]
        if (left != target) {
            l++
            continue
        }
        if (right == target) {
            r--
            continue
        }
        swap(array, l, r)
    }
    return array
}

private fun swap(array: MutableList<Int>, i: Int, j: Int) {
    var temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

fun main() {
    val array = mutableListOf(2, 1, 2, 2, 2, 3, 4, 2, 5)
    moveElementToEnd(array, 2)
    println(array)
}