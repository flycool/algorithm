package algo_algorithm.easy

fun middleNode(head: AlgoNode?): AlgoNode? {
    if (head == null) return null
    if (head.next == null) return head
    if (head.next!!.next == null) return head.next

    var curNode = head
    var n = 0
    while (curNode != null) {
        n++
        curNode = curNode.next
    }
    var middleNode = head
    for (i in 0 until n / 2) {
        middleNode = middleNode?.next
    }
    return middleNode
}

fun middleNode2(head: AlgoNode): AlgoNode {
    var slow = head
    var fast: AlgoNode? = head

    while (fast != null || fast?.next != null) {
        slow = slow.next!!
        fast = fast.next!!.next
    }
    return slow
}