package algo_algorithm.easy

fun commonCahracters(array: MutableList<String>): List<Char> {
    var minStr = array[0]
    for (str in array) {
        minStr = if (str.length < minStr.length) str else minStr
    }

    var commonChar = minStr.toHashSet()
    for (s in array) {
        val set = s.toHashSet()
        for (c in commonChar) {
            if (!set.contains(c)) {
                commonChar.remove(c)
            }
        }
    }
    return commonChar.toMutableList()
}