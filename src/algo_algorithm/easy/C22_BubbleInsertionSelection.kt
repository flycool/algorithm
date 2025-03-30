package algo_algorithm.easy

fun bubbleSort(array: MutableList<Int>): List<Int> {
    for (i in array.size - 1 downTo 0) {
        for (j in 0 until i) {
            if (array[j] > array[i]) {
                swap(array, j, i)
            }
        }
    }
    return array
}

fun insertionSort(array: MutableList<Int>): List<Int> {
    for (i in 1 until array.size) {
        var j = i - 1
        while (j > 0 && array[j] < array[j - 1]) {
            swap(array, j, j - 1)
            j--
        }
    }
    return array
}

fun selectionSort(array: MutableList<Int>): List<Int> {
    var minIndex = 0
    for (i in 0 until array.size - 1) {
        minIndex = i
        for (j in i + 1 until array.size) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }
        swap(array, i, minIndex)
    }
    return array
}


private fun swap(array: MutableList<Int>, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}