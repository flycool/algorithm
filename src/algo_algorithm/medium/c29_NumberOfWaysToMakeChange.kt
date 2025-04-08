package algo_algorithm.medium

fun numberOfWaysToMakeChange(n: Int, denoms: List<Int>): Int {
    val ways = MutableList(n + 1) { 0 }
    ways[0] = 1
    for (denom in denoms) {
        for (amount in 1..n) {
            if (denom <= amount) {
                ways[amount] += ways[amount - denom]
            }
        }
    }
    return ways[n]
}

fun main() {
    val denoms = listOf(1, 5, 10, 25)
    println(numberOfWaysToMakeChange(10, denoms))
}