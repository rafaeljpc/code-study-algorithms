package io.github.rafaeljpc.study.algorithms.sort

object IntArrayMergeSort : IntArraySortInterface {

    private fun merge(input: IntArray, low: Int, mid: Int, high: Int) {
        val leftSize = mid - low + 1
        val rightSize = high - mid

        val left = IntArray(leftSize)
        val right = IntArray(rightSize)

        for (i in 0 until leftSize) {
            left[i] = input[low + i]
        }
        for (j in 0 until rightSize) {
            right[j] = input[mid + 1 + j]
        }

        var i = 0
        var j = 0
        var k = low

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                input[k++] = left[i++]
            } else {
                input[k++] = right[j++]
            }
        }

        while (i < leftSize) {
            input[k++] = left[i++]
        }

        while (j < rightSize) {
            input[k++] = right[j++]
        }
    }

    private fun mergeSort(input: IntArray, low: Int, high: Int) {
        if (low < high) {
            val mid = low + (high - low) / 2
            mergeSort(input, low, mid)
            mergeSort(input, mid + 1, high)
            merge(input, low, mid, high)
        }
    }

    override fun sort(input: IntArray): IntArray {
        val result = input.clone()
        mergeSort(result, 0, result.size - 1)
        return result
    }

    override fun toString(): String {
        return "IntArrayMergeSort"
    }
}
