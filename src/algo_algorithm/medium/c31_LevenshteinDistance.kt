package algo_algorithm.medium

import kotlin.math.min

fun levenshteinDistance(str1: String, str2: String): Int {
    val ans = List(str2.length + 1) { MutableList(str1.length + 1) { j -> j } }
    for (i in 0 until str2.length + 1) {
        for (j in 0 until str1.length + 1) {
            ans[i][j] = j
        }
        ans[i][0] = i
    }

    for (i in 1 until str2.length + 1) {
        for (j in 1 until str1.length + 1) {
            if (str2[i - 1] == str1[j - 1]) {
                ans[i][j] = ans[i - 1][j - 1]
            } else {
                ans[i][j] = 1 + min(min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1])
            }
        }
    }

    return ans[str2.length][str1.length]
}

fun main() {
    val str1 = "abc"
    val str2 = "yabd"
    println(levenshteinDistance(str1, str2))
}