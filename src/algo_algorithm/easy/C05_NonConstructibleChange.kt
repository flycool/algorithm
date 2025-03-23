package algo_algorithm.easy

class C05_NonConstructibleChange {

    fun nonConstructibleChange(coins: MutableList<Int>): Int {
        coins.sorted()

        var change = 0 // 1... change 都能得到
        for (coin in coins) {
            if (coin > (change + 1)) {
                break
            }
            change += coin
        }
        return change + 1
    }
}