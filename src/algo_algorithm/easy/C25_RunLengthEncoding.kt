package algo_algorithm.easy

fun runLengthEncoding(string: String): String {
    val chars = mutableListOf<Char>()
    var length = 1
    for (i in 1 until string.length) {
        if (string[i] == string[i - 1] && length < 9) {
            length += 1
        } else {
            chars.add(length.toString()[0])
            chars.add(string[i - 1])
            length = 1
        }
    }
    // handle the last run
    chars.add(length.toString()[0])
    chars.add(string[string.length - 1])

    return chars.joinToString("")
}

fun main() {
    val s = "AAAAAAAAAAAAAAABBBCCCDD"
    val ans = runLengthEncoding(s)
    print(ans) //9A6A3B3C2D
}