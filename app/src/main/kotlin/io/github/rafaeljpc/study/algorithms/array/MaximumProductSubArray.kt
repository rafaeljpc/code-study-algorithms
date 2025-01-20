package io.github.rafaeljpc.study.algorithms.array

object MaximumProductSubArray {
    fun calc(array: IntArray): Any {
        val n = array.size
        var currMax = array[0]
        var currMin = array[0]
        var maxProd = array[0]

        for (i in 1 until n) {
            val temp = maxOf(array[i], array[i] * currMax, array[i] * currMin)
            currMin = minOf(array[i], array[i] * currMax, array[i] * currMin)
            currMax = temp
            maxProd = maxOf(maxProd, currMax)
        }

        return maxProd
    }
}
