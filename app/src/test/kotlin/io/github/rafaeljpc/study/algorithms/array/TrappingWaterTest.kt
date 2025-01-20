package io.github.rafaeljpc.study.algorithms.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TrappingWaterTest {

    private companion object {
        @JvmStatic
        fun provideInputAndExpectedOutput() =
            listOf(
                Arguments.of(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1), 6),
                Arguments.of(intArrayOf(4, 2, 0, 3, 2, 5), 9),
                Arguments.of(intArrayOf(2, 1, 5, 3, 1, 0, 4), 9),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 0),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1), 0),
                Arguments.of(intArrayOf(0, 0, 0, 0), 0),
            )
    }

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedOutput")
    fun testTrappingWater(heights: IntArray, expected: Int) {
        val solution = TrappingWater.maxWater(heights)
        assertThat(solution).isEqualTo(expected)
    }
}
