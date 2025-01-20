package io.github.rafaeljpc.study.algorithms.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RotateArrayKStepsTest {

    companion object {
        @JvmStatic
        fun providedTestData() = listOf(
            Arguments.of(intArrayOf(1, 3, 5, 7, 9), 2, intArrayOf(7, 9, 1, 3, 5)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 3, intArrayOf(3, 4, 5, 1, 2)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6), 4, intArrayOf(3, 4, 5, 6, 1, 2)),
            Arguments.of(intArrayOf(6, 7, 8, 1, 2, 3), 3, intArrayOf(1, 2, 3, 6, 7, 8)),
        )
    }

    @ParameterizedTest
    @MethodSource("providedTestData")
    fun testRotate(array: IntArray, k: Int, expected: IntArray) {
        val result = RotateArrayKSteps.calc(array, k)
        assertThat(result).isEqualTo(expected)
    }
}
