package io.github.rafaeljpc.study.algorithms.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class EquilibriumIndexTest {

    companion object {
        @JvmStatic
        fun provideInputAndExpectedOutput() = listOf(
            Arguments.of(intArrayOf(1, 2, 0, 3), 2),
            Arguments.of(intArrayOf(1, 1, 1, 1), -1),
            Arguments.of(intArrayOf(-7, 1, 5, 2, -4, 3, 0), 3),

            )
    }

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedOutput")
    fun testEquilibriumIndex(input: IntArray, expected: Int) {
        val result = EquilibriumIndex.findEquilibriumIndex(input)
        assertThat(result).isEqualTo(expected)
    }
}
