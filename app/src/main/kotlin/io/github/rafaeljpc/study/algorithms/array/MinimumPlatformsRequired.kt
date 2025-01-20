package io.github.rafaeljpc.study.algorithms.array

import kotlin.math.max

object MinimumPlatformsRequired {
    fun calc(arrivals: IntArray, departures: IntArray): Int {
        val arrivalsSorted = arrivals.sorted()
        val departuresSorted = departures.sorted()

        var platformNeeded = 1
        var result = 1
        var i = 1
        var j = 0

        while (i < arrivals.size && j < departures.size) {
            if (arrivalsSorted[i] <= departuresSorted[j]) {
                platformNeeded++
                i++
            } else if (arrivalsSorted[i] > departuresSorted[j]) {
                platformNeeded--
                j++
            }

            result = max(platformNeeded, result)
        }

        return result
    }
}
