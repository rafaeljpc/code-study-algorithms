package io.github.rafaeljpc.study.algorithms.array

import io.github.oshai.kotlinlogging.KotlinLogging

val log = KotlinLogging.logger { }

object TrappingWater {

    fun maxWater(heights: IntArray): Int {
        var left = 1
        var right = heights.size - 2
        var leftMax = heights[left - 1]
        var rightMax = heights[right + 1]
        var waterTrapped = 0

        while (left <= right) {
            if (rightMax <= leftMax) {
                waterTrapped += maxOf(0, rightMax - heights[right])
                rightMax = maxOf(rightMax, heights[right])
                right -= 1
            } else {
                waterTrapped += maxOf(0, leftMax - heights[left])
                leftMax = maxOf(leftMax, heights[left])
                left += 1
            }
        }

        return waterTrapped
    }
}
