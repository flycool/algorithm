package algo_algorithm.easy

import kotlin.math.abs


fun findClosestValueInBST(root: BinaryTree?, target: Int): Int {
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

