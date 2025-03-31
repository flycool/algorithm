package algo_algorithm.easy

fun caesarCipherEncryptor(string: String, key: Int): String {
    var newKey = key % 26
    val newLetters = mutableListOf<Char>()
    for (letter in string) {
        newLetters.add(getNewLetter(letter, newKey))
    }
    return newLetters.joinToString("")
}

fun getNewLetter(letter: Char, key: Int): Char {
    val newLetterCode = letter.code + key
    return if (newLetterCode <= 122) newLetterCode.toChar() else
        (96 + newLetterCode % 122).toChar()
}