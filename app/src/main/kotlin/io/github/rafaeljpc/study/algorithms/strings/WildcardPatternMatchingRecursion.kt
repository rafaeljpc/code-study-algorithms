package io.github.rafaeljpc.study.algorithms.strings

object WildcardPatternMatchingRecursion : WildcardPatternMatchingInterface {
    private fun isMatchHelper(input: String, pattern: String, n: Int, m: Int): Boolean {
        if (m == 0) {
            return n == 0
        }

        if (n == 0) {
            for (i in 0 until m) {
                if (pattern[i] != '*') {
                    return false
                }
            }
            return true
        }

        if (input[n - 1] == pattern[m - 1] || pattern[m - 1] == '?') {
            return isMatchHelper(input, pattern, n - 1, m - 1)
        }

        if (pattern[m - 1] == '*') {
            return isMatchHelper(input, pattern, n - 1, m) || isMatchHelper(input, pattern, n, m - 1)
        }

        return false
    }

    override fun isMatch(input: String, pattern: String): Boolean =
        isMatchHelper(input, pattern, input.length, pattern.length)

    override fun toString(): String {
        return "WildcardPatternMatchingRecursion"
    }
}
