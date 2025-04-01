package algo_algorithm.easy

fun generateDocument(characters: String, document: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    for (c in characters) {
        map.put(c, map.getOrDefault(c, 0) + 1)
    }
    for (c in document) {
        if ((c !in map) || map[c] == 0) {
            return false
        }
        map.put(c, map[c]!! - 1)
    }
    return true
}

fun main() {
    val characters = "Bste!hetsi ogEAxpelrt x "
    val document = "AlgoExpert is the Best!"
    val b = generateDocument(characters, document)
    print(b)
}