package algo_algorithm.medium

fun missingNumbers(nums: MutableList<Int>): List<Int> {
    var solutionXOR = 0
    for (i in 0..nums.size + 2) {
        solutionXOR = solutionXOR xor i
        if (i < nums.size) {
            solutionXOR = solutionXOR xor nums[i]
        }
    }

    val solution = mutableListOf(0, 0)
    // 计算哪位有1
    val setBit = solutionXOR and -solutionXOR

    for (i in 0..nums.size + 2) {
        if ((i and setBit) == 0) {
            solution[0] = solution[0] xor i
        } else {
            solution[1] = solution[1] xor i
        }

        if (i < nums.size) {
            if ((nums[i] and setBit) == 0) {
                solution[0] = solution[0] xor nums[i]
            } else {
                solution[1] = solution[1] xor nums[i]
            }
        }
    }

    solution.sort()
    return solution
}

fun main() {
    val array = mutableListOf(1, 4, 3, 5)
    println(missingNumbers(array))
}