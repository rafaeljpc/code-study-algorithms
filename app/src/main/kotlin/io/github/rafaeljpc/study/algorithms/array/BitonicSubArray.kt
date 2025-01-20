package io.github.rafaeljpc.study.algorithms.array

import io.github.oshai.kotlinlogging.KotlinLogging

object BitonicSubArray {

    private val log = KotlinLogging.logger { }

    fun findBitonicSubArray(input: IntArray): IntArray {
        val n = input.size
        val inc = IntArray(n)
        val dec = IntArray(n)

        inc[0] = 1
        for (i in 1 until n) {
            inc[i] = if (input[i - 1] < input[i]) inc[i - 1] + 1 else 1
        }

        dec[n - 1] = 1
        for (i in n - 2 downTo 0) {
            dec[i] = if (input[i] > input[i + 1]) dec[i + 1] + 1 else 1
        }

        log.debug {
            """
                input: ${input.joinToString(",", "[", "]")}
                inc: ${inc.joinToString(",", "[", "]")}
                dec: ${dec.joinToString(",", "[", "]")}
            """.trimIndent()
        }

        var lbsLen = 1
        var start = 0
        var end = 0

        for (i in input.indices) {
            if (inc[i] + dec[i] - 1 > lbsLen) {
                lbsLen = inc[i] + dec[i] - 1
                start = i - inc[i] + 1
                end = i + dec[i] - 1
            }
        }

        log.debug { "start: $start, end: $end" }

        return input.sliceArray(start..end)
    }
}
