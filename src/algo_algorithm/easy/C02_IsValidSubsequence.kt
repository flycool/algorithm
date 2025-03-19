package algo_algorithm.easy


fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var n = array.size
    var sn = sequence.size
    var oleft = 0
    var sleft = 0
    while (oleft < n && sleft < sn) {
        if (array[oleft] == sequence[sleft]) {
            sleft++
        }
        oleft++
    }
    return sleft == sequence.size
}

fun isValidSubsequence2(array: List<Int>, sequence: List<Int>): Boolean {
    var seqIdx = 0
    for (value in array) {
        if (seqIdx == sequence.size) break
        if (sequence[seqIdx] == value) seqIdx++
    }
    return seqIdx == sequence.size
}