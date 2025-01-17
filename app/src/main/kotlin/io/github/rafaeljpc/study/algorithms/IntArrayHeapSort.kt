package io.github.rafaeljpc.study.algorithms

object IntArrayHeapSort : IntArraySortInterface {

    // 5, 3, 8, 4, 2, 7, 6, 1, 9

    private fun heapify(array: IntArray, size: Int, root: Int) {
        var largest = root
        val left = 2 * root + 1
        val right = 2 * root + 2

        if (left < size && array[left] > array[largest]) {
            largest = left
        }

        if (right < size && array[right] > array[largest]) {
            largest = right
        }

        if (largest != root) {
            val temp = array[root]
            array[root] = array[largest]
            array[largest] = temp

            heapify(array, size, largest)
        }
    }

    private fun heapsort(input: IntArray) {
        val size = input.size

        for (i in size / 2 - 1 downTo 0) {
            heapify(input, size, i)
        }

        for (i in size - 1 downTo 1) {
            val temp = input[0]
            input[0] = input[i]
            input[i] = temp
            heapify(input, i, 0)
        }
    }

    override fun sort(input: IntArray): IntArray {
        val result = input.clone()
        heapsort(result)
        return result
    }

    override fun toString(): String {
        return "IntArrayHeapSort"
    }


}
