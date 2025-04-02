package algo_algorithm.medium

import kotlin.math.abs

fun smallestDifference(arrayA: List<Int>, arrayB: List<Int>): List<Int> {
    arrayA.sorted()
    arrayB.sorted()

    var i = 0
    var j = 0
    var smallest = abs(arrayA[i] - arrayB[j])
    var current = 0
    var smallestPair = listOf<Int>()
    while (i < arrayA.size && j < arrayB.size) {
        var firstNum = arrayA[i]
        var seconNum = arrayB[j]
        if (firstNum == seconNum) {
           return listOf(firstNum, seconNum)
        } else if (firstNum < seconNum) {
            current = seconNum - firstNum
            i++
        } else if (firstNum > seconNum) {
            current = firstNum - seconNum
            j++
        }
        if (current < smallest) {
            smallest = current
            smallestPair = listOf(firstNum, seconNum)
        }
    }

    return smallestPair
}

fun main() {
    val arrayA = listOf(-1, 5, 10, 20, 28, 3)
    val arrayB = listOf(26, 134, 135, 15, 17)
    val ans = smallestDifference(arrayA, arrayB)
    println(ans)
}