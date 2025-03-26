package algo_algorithm.easy

class Node(val name: String) {
    val children = mutableListOf<Node>()

    fun addChild(name: String): Node {
        children.add(Node(name))
        return this
    }

    fun depthFirstSearch(): List<String> {
        return depthFirstSearch(mutableListOf())
    }

    // time: O(v+e) | space: O(v)
    fun depthFirstSearch(array: MutableList<String>): List<String> {
        array.add(this.name)
        for (child in this.children) {
            child.depthFirstSearch(array)
        }
        return array
    }
}
