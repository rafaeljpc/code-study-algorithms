package io.github.rafaeljpc.study.algorithms.array

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LeaderInArrayTest {

    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            Arguments.of(intArrayOf(16, 17, 4, 3, 5, 2), listOf(17, 5, 2)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), listOf(5)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5, 2), listOf(5, 2)),
            Arguments.of(intArrayOf(1, 11, 5, 2, 6, 3, 4), listOf(11, 6, 4)),
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun testFindLeaders(arr: IntArray, expected: List<Int>) {
        val result = LeaderInArray.findLeaders(arr)
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
