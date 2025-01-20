package io.github.rafaeljpc.study.algorithms.array

object RotateArrayKSteps {
    fun calc(array: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val steps = k % array.size
        val n = array.size

        for (i in array.indices) {
            if (i < steps) {
                result.add(array[n + i - steps])
            } else {
                result.add(array[i - steps])
            }
        }
        return result.toIntArray()
    }
}
