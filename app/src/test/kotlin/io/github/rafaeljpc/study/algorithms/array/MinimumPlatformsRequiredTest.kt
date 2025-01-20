package io.github.rafaeljpc.study.algorithms.array

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class MinimumPlatformsRequiredTest {
    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            Arguments.of(
                intArrayOf(900, 940, 950, 1100, 1500, 1800),
                intArrayOf(910, 1200, 1120, 1130, 1900, 2000),
                3,
            ),
            Arguments.of(
                intArrayOf(900, 940),
                intArrayOf(910, 1200),
                1,
            ),
            Arguments.of(
                intArrayOf(100, 300, 500),
                intArrayOf(900, 400, 600),
                2,
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun testMinimumPlatformsRequired(arrivals: IntArray, departures: IntArray, expected: Int) {
        val result = MinimumPlatformsRequired.calc(arrivals, departures)
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
