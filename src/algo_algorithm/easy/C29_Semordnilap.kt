package algo_algorithm.easy

fun semordnilap(words: List<String>): List<List<String>> {
    val set = words.toMutableSet()
    val ans = mutableListOf<List<String>>()

    for (word in words) {
        val reverseWord = word.reversed()
        if (set.contains(reverseWord) && word != reverseWord) {
            ans.add(listOf(word, reverseWord))
            set.remove(word)
            set.remove(reverseWord)
        }
    }
    return ans
}