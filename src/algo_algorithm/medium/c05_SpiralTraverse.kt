package algo_algorithm.medium

fun spiralTraverse(array: List<List<Int>>): List<Int> {
    var sr = 0
    var er = array.size - 1
    var sc = 0
    var ec = array[0].size - 1
    val ans = mutableListOf<Int>()
    while (sr <= er && sc <= ec) {
        for (c in sc .. ec) {
            ans.add(array[sr][c])
        }
        sr++
        for (r in sr .. er) {
            ans.add(array[r][ec])
        }
        ec--
        for (c in ec downTo sc) {
            ans.add(array[er][c])
        }
        er--
        for (r in er downTo sr) {
            ans.add(array[r][sc])
        }
        sc++
    }
    return ans
}

fun main() {
    val list = mutableListOf<List<Int>>(
        listOf(1, 2, 3, 4),
        listOf(12, 13, 14, 5),
        listOf(11, 16, 15, 6),
        listOf(10, 9, 8, 7),
//        listOf(23, 24, 25, 26),
    )
    val ans = spiralTraverse(list)
    println(ans)
}