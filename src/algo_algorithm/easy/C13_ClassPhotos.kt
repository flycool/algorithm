package algo_algorithm.easy

fun classPhotos(blueShirts: MutableList<Int>, redShirts: MutableList<Int>): Boolean {
    blueShirts.sorted()
    redShirts.sorted()
    val blueFirstRow = blueShirts[blueShirts.size - 1] > redShirts[redShirts.size - 1]
    for (i in blueShirts.size - 1 downTo 0) {
        if (blueFirstRow && (blueShirts[i] <= redShirts[i])) {
            return false
        }
        if (!blueFirstRow && (blueShirts[i] >= redShirts[i])) {
            return false
        }
    }
    return true
}