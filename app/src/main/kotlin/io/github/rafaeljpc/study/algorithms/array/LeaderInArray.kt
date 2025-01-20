package io.github.rafaeljpc.study.algorithms.array

object LeaderInArray {
    fun findLeaders(arr: IntArray): List<Int> {
        val result = mutableListOf<Int>()

        var maxRight = arr[arr.size - 1]
        result.add(maxRight)

        for (i in arr.size - 2 downTo 0) {
            if (arr[i] >= maxRight) {
                maxRight = arr[i]
                result.add(maxRight)
            }
        }

        return result.reversed()
    }
}
