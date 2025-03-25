package algo_algorithm.easy

import java.util.Stack

fun nodeDepths(root: BinaryTree?): Int {
    if (root == null) return 0

    return f(root, 0)
}

fun f(node: BinaryTree?, depth: Int): Int {
    return f(node?.left, depth + 1) + f(node?.right, depth + 1) + depth
}

data class Level(
    val root: BinaryTree?,
    val depth: Int
)

fun nodeDepths2(root: BinaryTree?): Int {
    var depths = 0
    val stack = Stack<Level>()
    stack.add(Level(root, 0))
    while (stack.isNotEmpty()) {
        val top = stack.pop()
        val (node, depth) = top
        if (node == null) continue

        depths += depth
        stack.add(Level(node.left, depth + 1))
        stack.add(Level(node.right, depth + 1))
    }
    return depths
}