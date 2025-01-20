package io.github.rafaeljpc.study.algorithms.array

object EquilibriumIndex {

    fun findEquilibriumIndex(input: IntArray): Int {
        var prefSum = 0
        var total = 0

        for (i in input.indices) {
            total += input[i]
        }

        for (i in input.indices) {
            val sufSum = total - prefSum - input[i]
            if (prefSum == sufSum) {
                return i
            }
            prefSum += input[i]
        }

        return -1
    }

}
