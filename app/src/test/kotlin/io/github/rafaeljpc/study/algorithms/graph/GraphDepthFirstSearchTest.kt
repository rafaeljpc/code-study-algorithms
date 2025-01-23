package io.github.rafaeljpc.study.algorithms.graph

import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class GraphDepthFirstSearchTest {

    companion object {
        @JvmStatic
        private val log = KotlinLogging.logger { }

        private val graph1 = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
        )

        private val graph2 = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 0),
            intArrayOf(0, 3),
            intArrayOf(4, 5),
        )

        @JvmStatic
        fun provideGraphDFSTestData() = listOf(
            Arguments.of(5, graph1, 1, intArrayOf(1, 2, 0, 3, 4)),
        )

        @JvmStatic
        fun provideGraphDFSPrintAllTestData() = listOf(
            Arguments.of(7, graph1, intArrayOf(0, 2, 1, 3, 4, 5, 6)),
            Arguments.of(6, graph2, intArrayOf(0, 2, 1, 3, 4, 5)),
        )
    }

    @ParameterizedTest
    @MethodSource("provideGraphDFSTestData")
    fun testDepthFirstSearch(graphSize: Int, edges: Array<IntArray>, startNode: Int, expectedResult: IntArray) {
        val graph = GraphDFS(graphSize, edges)

        log.debug { "graph=$graph" }

        val result = graph.depthFirstSearch(startNode)
        assertThat(result)
            .containsExactlyInAnyOrderElementsOf(expectedResult.asList())
    }

    @ParameterizedTest
    @MethodSource("provideGraphDFSPrintAllTestData")
    fun testPrintAllWithDFS(graphSize: Int, edges: Array<IntArray>, expectedResult: IntArray) {
        val graph = GraphDFS(graphSize, edges)

        log.debug { "graph=$graph" }

        val result = graph.allNodes()
        assertThat(result)
            .containsExactlyInAnyOrderElementsOf(expectedResult.asList())
    }
}
