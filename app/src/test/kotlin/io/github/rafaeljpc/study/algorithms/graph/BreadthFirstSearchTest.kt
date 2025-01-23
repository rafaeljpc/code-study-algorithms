package io.github.rafaeljpc.study.algorithms.graph

import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class BreadthFirstSearchTest {

    companion object {
        private val log = KotlinLogging.logger { }

        @JvmStatic
        fun providedTestData() = listOf(
            Arguments.of(
                GraphBFS(
                    5,
                    arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(1, 3),
                        intArrayOf(1, 4),
                        intArrayOf(2, 4),
                    ),
                ),
                intArrayOf(0, 1, 2, 3, 4),
            ),
            Arguments.of(
                GraphBFS(
                    5,
                    arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(1, 2),
                        intArrayOf(1, 4),
                        intArrayOf(2, 3),
                        intArrayOf(3, 4),
                        intArrayOf(3, 1),
                    ),
                ),
                intArrayOf(0, 1, 2, 3, 4),
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("providedTestData")
    fun testBreadthFirstSearch(graph: GraphBFS, expected: IntArray) {
        log.debug { "graph=$graph" }
        val result = graph.bfs(0)
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected.asList())
    }
}
