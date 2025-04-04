package algo_algorithm.medium

fun arrayOfProducts(array: List<Int>): List<Int> {
    val ans = mutableListOf<Int>()
    var totalProduct = 1
    for (el in array) {
        totalProduct *= el
    }
    for (el in array) {
        ans.add(totalProduct / el)
    }
    return ans
}

fun main() {
    val array = listOf(5, 1, 4, 2)
    println(arrayOfProducts(array))
}