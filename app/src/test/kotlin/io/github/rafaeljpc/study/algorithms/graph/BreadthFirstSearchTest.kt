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
        fun providedTestDataBFS() = listOf(
            Arguments.of(
                GraphBFS(
                    graphSize = 5,
                    edges = arrayOf(
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
                    graphSize = 5,
                    edges = arrayOf(
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
            Arguments.of(
                GraphBFS(
                    graphSize = 10,
                    edges = arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(1, 2),
                        intArrayOf(1, 3),
                        intArrayOf(1, 4),
                        intArrayOf(2, 4),
                        intArrayOf(2, 5),
                        intArrayOf(3, 6),
                        intArrayOf(4, 7),
                        intArrayOf(5, 7),
                        intArrayOf(7, 3),
                        intArrayOf(8, 9),
                    ),
                ),
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
            ),
        )

        @JvmStatic
        fun providedTestDataCyclic() = listOf(
            Arguments.of(
                GraphBFS(
                    graphSize = 6,
                    edges = arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(1, 3),
                        intArrayOf(4, 1),
                        intArrayOf(4, 5),
                        intArrayOf(5, 3),
                        intArrayOf(3, 5),
                    ),
                ),
                true
            ),
            Arguments.of(
                GraphBFS(
                    graphSize = 6,
                    edges = arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(1, 3),
                        intArrayOf(4, 1),
                        intArrayOf(4, 5),
                        intArrayOf(5, 3),
                    ),
                ),
                false
            ),
            Arguments.of(
                GraphBFS(
                    graphSize = 6,
                    edges = arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(0, 2),
                        intArrayOf(1, 3),
                        intArrayOf(4, 1),
                        intArrayOf(4, 5),
                    ),
                ),
                false
            ),
            Arguments.of(
                GraphBFS(
                    graphSize = 5,
                    edges = arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(1, 2),
                        intArrayOf(1, 4),
                        intArrayOf(2, 3),
                        intArrayOf(3, 4),
                        intArrayOf(3, 1),
                    ),
                ),
                true
            ),
            Arguments.of(
                GraphBFS(
                    graphSize = 5,
                    edges = arrayOf(
                        intArrayOf(0, 1),
                        intArrayOf(1, 2),
                        intArrayOf(2, 3),
                        intArrayOf(3, 4),
                    ),
                ),
                false
            ),
        )

    }

    @ParameterizedTest
    @MethodSource("providedTestDataBFS")
    fun testBreadthFirstSearch(graph: GraphBFS, expected: IntArray) {
        log.debug { "graph=$graph" }
        val result = graph.bfsWithDisconnected()
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected.asList())
    }

    @ParameterizedTest
    @MethodSource("providedTestDataCyclic")
    fun testCyclicGraph(graph: GraphBFS, expected: Boolean) {
        log.debug { "graph=$graph" }
        val result = graph.isCyclic() as Boolean
        Assertions.assertThat(result).isEqualTo(expected)
    }


}
