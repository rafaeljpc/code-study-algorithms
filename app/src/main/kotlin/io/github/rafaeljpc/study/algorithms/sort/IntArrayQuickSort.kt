package io.github.rafaeljpc.study.algorithms.sort

object IntArrayQuickSort : IntArraySortInterface {

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    private fun partition(array: IntArray, low: Int, high: Int): Int {
        val pivot = array[high]
        var i = low - 1
        for (j in low until high) {
            if (array[j] < pivot) {
                i++
                swap(array, i, j)
            }
        }
        swap(array, i + 1, high)
        return i + 1
    }

    private fun quickSort(result: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(result, low, high)
            quickSort(result, low, pi - 1)
            quickSort(result, pi + 1, high)
        }
    }

    override fun sort(input: IntArray): IntArray {
        val result = input.clone()
        quickSort(result, 0, result.size - 1)
        return result
    }

    override fun toString(): String {
        return "IntArrayQuickSort"
    }
}
