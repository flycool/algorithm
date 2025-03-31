package algo_algorithm.easy

fun runLengthEncoding(string: String): String {
    val chars = mutableListOf<Char>()
    var length = 1
    for (i in 1 until string.length) {
        if (string[i] == string[i - 1] && length < 9) {
            length += 1
        } else {
            chars.add(length.toChar())
            chars.add(string[i - 1])
            length = 0
        }
    }
    // handle the last run
    chars.add(length.toChar())
    chars.add(string[string.length - 1])

    return chars.joinToString("")
}