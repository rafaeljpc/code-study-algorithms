package io.github.rafaeljpc.study.algorithms.strings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WildcardPatternMatchingTest {
    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            Arguments.of(WildcardPatternMatchingRecursion, "abcde", "a?c*", true),
            Arguments.of(WildcardPatternMatchingRecursion, "baaabab", "a*ab", false),
            Arguments.of(WildcardPatternMatchingRecursion, "baaabab", "*****ba*****ab", true),
            Arguments.of(WildcardPatternMatchingRecursion, "baaabab", "*****ba*****jab", false),
            Arguments.of(WildcardPatternMatchingRecursion, "abc", "a?c", true),
            Arguments.of(WildcardPatternMatchingRecursion, "azc", "a?c", true),
            Arguments.of(WildcardPatternMatchingRecursion, "auc", "a?c", true),
            Arguments.of(WildcardPatternMatchingRecursion, "abc", "*", true),

            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "abcde", "a?c*", true),
            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "baaabab", "a*ab", false),
            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "baaabab", "*****ba*****ab", true),
            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "baaabab", "*****ba*****jab", false),
            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "abc", "a?c", true),
            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "azc", "a?c", true),
            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "auc", "a?c", true),
            Arguments.of(WildcardPatternMatchingSimpleTraversalSolution, "abc", "*", true),
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun testWildcardPatternMatching(
        solver: WildcardPatternMatchingInterface,
        text: String,
        pattern: String,
        expected: Boolean,
    ) {
        val result = solver.isMatch(text, pattern)
        assertThat(result).isEqualTo(expected)
    }
}
