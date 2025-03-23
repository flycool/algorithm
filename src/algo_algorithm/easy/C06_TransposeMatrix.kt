package algo_algorithm.easy

fun transposeMatrix(matrix: List<List<Int>>): List<List<Int>> {
    val transposeMatrix = mutableListOf<MutableList<Int>>()
    for (col in 0 until matrix[0].size) {
        val newRow = mutableListOf<Int>()
        for (row in 0 until matrix.size) {
            newRow.add(matrix[row][col])
        }
        transposeMatrix.add(newRow)
    }
    return transposeMatrix
}