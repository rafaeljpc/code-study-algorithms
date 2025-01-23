package io.github.rafaeljpc.study.algorithms.strings

object WildcardPatternMatchingSimpleTraversalSolution : WildcardPatternMatchingInterface {
    override fun isMatch(input: String, pattern: String): Boolean {
        val n = input.length
        val m = pattern.length

        var i = 0
        var j = 0
        var starIndex = -1
        var matchIndex = 0

        while (i < n) {
            if (j < m && (input[i] == pattern[j] || pattern[j] == '?')) {
                i++
                j++
            } else if (j < m && pattern[j] == '*') {
                starIndex = j
                matchIndex = i
                j++
            } else if (starIndex != -1) {
                j = starIndex + 1
                matchIndex++
                i = matchIndex
            } else {
                return false
            }
        }

        while (j < m && pattern[j] == '*') {
            j++
        }
        return j == m
    }

    override fun toString(): String {
        return "WildcardPatternMatchingSimpleTraversalSolution"
    }
}
