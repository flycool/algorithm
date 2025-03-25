package algo_algorithm.easy

private fun getSign(sign: Int, a: Int, b: Int): Int {
    return when (sign) {
        -1 -> a + b
        -2 -> a - b
        -3 -> a / b
        else -> a * b
    }
}

fun evaluateExpressionTree(root: BinaryTree): Int {
    if (root.value >= 0) return root.value

    val leftValue = evaluateExpressionTree(root.left!!)
    val rightValue = evaluateExpressionTree(root.right!!)

    return getSign(root.value, leftValue, rightValue)
}

