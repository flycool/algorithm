package algo_algorithm.easy

import kotlin.math.max

fun tandemBicycle(
    redShirtSpeeds: MutableList<Int>,
    blueShirtSpeeds: MutableList<Int>,
    fastest: Boolean
): Int {
    redShirtSpeeds.sorted()
    blueShirtSpeeds.sorted()

    if (!fastest) reverseArrayInPlace(redShirtSpeeds)

    var totalSpeed = 0
    for (i in 0 until redShirtSpeeds.size) {
        val rider1 = redShirtSpeeds[i]
        val rider2 = blueShirtSpeeds[blueShirtSpeeds.size - 1 - i]
        totalSpeed += max(rider1, rider2)
    }
    return totalSpeed
}

fun reverseArrayInPlace(array: MutableList<Int>) {
    var start = 0
    var end = array.size - 1
    while (start < end) {
        val temp = array[start]
        array[start] = array[end]
        array[end] = temp
        start++
        end--
    }
}