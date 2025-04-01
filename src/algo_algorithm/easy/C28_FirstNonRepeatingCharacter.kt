package algo_algorithm.easy

fun firstNonRepeatingCharacter(string: String): Int {
    val map = mutableMapOf<Char, Int>()
    for (c in string) {
        map.put(c, map.getOrDefault(c, 0) + 1)
    }
    for (i in 0 until string.length) {
        if (map[string[i]] == 1) {
            return i
        }
    }
    return -1
}

