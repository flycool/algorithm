package algo_algorithm.easy

import kotlin.math.abs

open class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun findClosestValueInBST(root: TreeNode?, target: Int): Int {
    var closestValue = root?.value!!
    var curNode = root
    while (curNode != null) {
        if (abs(target - closestValue) > abs(target - curNode.value)) {
            closestValue = curNode.value
        }

        if (curNode.value > target) {
            curNode = curNode.left!!
        } else if (curNode.value < target) {
            curNode = curNode.right!!
        } else {
            break;
        }
    }
    return closestValue
}

