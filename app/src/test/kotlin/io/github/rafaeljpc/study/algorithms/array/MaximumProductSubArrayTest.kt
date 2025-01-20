package io.github.rafaeljpc.study.algorithms.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class MaximumProductSubArrayTest {

    companion object {
        @JvmStatic
        fun provideInputAndExpectedOutput() = listOf(
            Arguments.of(intArrayOf(-2, 6, -3, -10, 0, 2), 180),
            Arguments.of(intArrayOf(-1, -3, -10, 0, 60), 60),
            Arguments.of(intArrayOf(2, 3, -2, 4), 6),
            Arguments.of(intArrayOf(-2, 0, -1), 0),
            Arguments.of(intArrayOf(0, 2), 2),
            Arguments.of(intArrayOf(-2, -3, -4), 12),
            Arguments.of(intArrayOf(2, 3, 4, 5, -20, 3, 4, 5, 6), 360),
        )
    }

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedOutput")
    fun testMaximumProductSubArray(array: IntArray, expected: Int) {
        val solution = MaximumProductSubArray.calc(array)
        assertThat(solution).isEqualTo(expected)
    }
}
