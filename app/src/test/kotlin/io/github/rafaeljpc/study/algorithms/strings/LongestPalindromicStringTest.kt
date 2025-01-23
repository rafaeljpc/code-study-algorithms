package io.github.rafaeljpc.study.algorithms.strings

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LongestPalindromicStringTest {

    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            Arguments.of("forgeeksskeegfor", "geeksskeeg"),
            Arguments.of("olhasubinoonibus", "subinoonibus"),
            Arguments.of("Geeks", "ee"),
            Arguments.of("abca", "a"),
            Arguments.of("", ""),
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun testLongestPalindromicString(input: String, expected: String) {
        val result = LongestPalindromicString.cal(input)
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
