package io.github.rafaeljpc.study.algorithms.strings

object LongestPalindromicString {
    fun cal(input: String): String {
        val n = input.length
        if (n == 0) return ""

        var start = 0
        var maxLength = 1

        for (i in 0 until n) {
            for (j in (0..1)) { // 0 for odd length and 1 for even length palindromes
                var low = i
                var hi = i + j

                while (low >= 0 && hi < n && input[low] == input[hi]) {
                    val currLen = hi - low + 1
                    if (currLen > maxLength) {
                        start = low
                        maxLength = currLen
                    }
                    low--
                    hi++
                }
            }
        }

        return input.substring(start, start + maxLength)
    }

}
