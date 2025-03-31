package algo_algorithm.easy

fun palindromeCheck(string: String): Boolean {
    var l = 0
    var r = string.length - 1
    while (l < r) {
        if (string[l++] != string[r--]) {
            return false
        }
    }
    return true
}