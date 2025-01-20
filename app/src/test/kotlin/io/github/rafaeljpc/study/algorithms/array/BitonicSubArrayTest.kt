package io.github.rafaeljpc.study.algorithms.array

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class BitonicSubArrayTest {

    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            Arguments.of(intArrayOf(1), intArrayOf(1)),
            Arguments.of(intArrayOf(3, 2, 3, 4, 5, 3, 2, 1, 5, 2, 3), intArrayOf(2, 3, 4, 5, 3, 2, 1)),
            Arguments.of(intArrayOf(1, 2, 3, 2, 3, 4, 5, 3, 2, 1, 5, 2, 3), intArrayOf(2, 3, 4, 5, 3, 2, 1)),
            Arguments.of(intArrayOf(1, 2, 5, 6, 3, 2, 1, 0, 6, 3, 2, 1, 0), intArrayOf(1, 2, 5, 6, 3, 2, 1, 0)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)),
            Arguments.of(intArrayOf(5, 4, 3, 2, 1), intArrayOf(5, 4, 3, 2, 1)),
            Arguments.of(intArrayOf(20, 4, 1, 2, 3, 4, 2, 10), intArrayOf(1, 2, 3, 4, 2)),
            Arguments.of(intArrayOf(12, 4, 78, 90, 45, 23), intArrayOf(4, 78, 90, 45, 23)),
            Arguments.of(intArrayOf(4, 5, 9, 5, 6, 10, 11, 9, 6, 4, 5), intArrayOf(5, 6, 10, 11, 9, 6, 4)),
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun testFindBitonicSubArray(input: IntArray, expectedOutput: IntArray) {
        val result = BitonicSubArray.findBitonicSubArray(input)
        assertThat(result).isEqualTo(expectedOutput)
    }
}
