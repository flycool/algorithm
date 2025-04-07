package algo_algorithm.medium

fun sweetAndSavory(dishes: List<Int>, target: Int): List<Int> {
    val sweetDishes = dishes.filter { dish -> dish < 0 }.toMutableList()
    val savoryDishes = dishes.filter { dish -> dish > 0 }.toMutableList()
    sweetDishes.sortDescending()
    savoryDishes.sort()

    var bestPair = listOf(0, 0)
    var bestDifference = Int.MAX_VALUE
    var sweetIndex = 0
    var savoryIndex = 0
    while (sweetIndex < sweetDishes.size && savoryIndex < savoryDishes.size) {
        val currentSum = sweetDishes[sweetIndex] + savoryDishes[savoryIndex]

        if (currentSum <= target) {
            val currentDifference = target - currentSum
            if (currentDifference < bestDifference) {
                bestDifference = currentDifference
                bestPair = listOf(sweetDishes[sweetIndex], savoryDishes[savoryIndex])
            }
            savoryIndex++
        } else {
            sweetIndex++
        }
    }
    return bestPair
}

fun main() {
    val array = listOf(5, 2, -7, 30, 12, -4, -20)
    println(sweetAndSavory(array, 4))
}