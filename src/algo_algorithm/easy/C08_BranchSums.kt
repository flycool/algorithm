package algo_algorithm.easy

private class Tree(val value: Int) {
    var left: Tree? = null
    var right: Tree? = null
}

// time: O(n) | space: O(n)
private fun branchSums(root: Tree): List<Int> {
    val sums = mutableListOf<Int>()
    calculateBranchSums(root, 0, sums)
    return sums
}

private fun calculateBranchSums(node: Tree?, runningSum: Int, sums: MutableList<Int>) {
    if (node == null) return

    val newRunningSum = runningSum + node.value
    if (node.left == null && node.right == null) {
        sums.add(newRunningSum)
        return
    }

    calculateBranchSums(node.left, newRunningSum, sums)
    calculateBranchSums(node.right, newRunningSum, sums)
}
