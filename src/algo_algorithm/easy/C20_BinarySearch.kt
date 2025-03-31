package algo_algorithm.easy

fun binarySearch(array: List<Int>, target: Int): Int {
    var l = 0
    var r = array.size - 1
    while (l <= r) {
        var m = l + (r - l) / 2
        if (array[m] > target) {
            r = m - 1
        } else if (array[m] < target) {
            l = m + 1
        } else {
            return array[m]
        }
    }
    return -1
}