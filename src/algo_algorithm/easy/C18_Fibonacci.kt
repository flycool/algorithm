package algo_algorithm.easy

// time: O(2^n) space: O(n)
fun fibonacci(n: Int): Int {
    if (n == 0 || n == 1) return n
    return fibonacci(n - 1) + fibonacci(n - 2)
}

// time: O(n) space: O(n)
fun fibonacci2(n: Int): Int {
    val cache = mutableMapOf<Int, Int>(1 to 0, 2 to 1)
    return getNthFib(n, cache)
}

fun getNthFib(n: Int, cache: MutableMap<Int, Int>): Int {
    if (cache.containsKey(n)) return cache[n]!!
    cache[n] = getNthFib(n - 1, cache) + getNthFib(n - 2, cache)
    return cache[n]!!

}

// time: O(n) space: O(1)
fun fibonacci3(n: Int): Int {
    var lastTwo = Pair(0, 1)
    var counter = 3
    while (counter <= n) {
        val nextFib = lastTwo.first + lastTwo.second
        lastTwo = Pair(lastTwo.second, nextFib)
        counter++
    }
    return if (n < 1) lastTwo.first else lastTwo.second
}