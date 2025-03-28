package algo_algorithm.easy

fun removeDuplicatesFromLinkedList(head: AlgoNode?): AlgoNode? {
    if (head == null) return null

    var curNode = head
    while (curNode != null) {
        var nextDistinctNode = curNode.next
        while (curNode.value == nextDistinctNode?.value) {
            nextDistinctNode = nextDistinctNode.next
        }
        curNode.next = nextDistinctNode
        curNode = nextDistinctNode
    }
    return head
}
