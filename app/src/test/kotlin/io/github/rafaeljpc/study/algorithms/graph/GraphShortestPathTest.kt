package io.github.rafaeljpc.study.algorithms.graph

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.rafaeljpc.study.algorithms.graph.WeightedGraph.Edge
import io.github.rafaeljpc.study.algorithms.graph.WeightedGraph.Node
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class GraphShortestPathTest {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    @Test
    fun `should find shortest path in weighted graph using Dijkstra's algorithm`() {
        // Given
        val graph = WeightedGraph(
            numVertices = 9,
            edges = listOf(
                Edge(0, 1, 4),
                Edge(0, 7, 8),

                Edge(1, 2, 8),
                Edge(1, 7, 11),

                Edge(2, 3, 7),
                Edge(2, 8, 2),
                Edge(2, 5, 4),

                Edge(3, 4, 9),
                Edge(3, 5, 14),

                Edge(4, 5, 10),

                Edge(5, 6, 2),

                Edge(6, 7, 1),
                Edge(6, 8, 6),

                Edge(7, 8, 7),
            )
        )
        log.debug { "graph=$graph" }

        // When
        val resultPath = graph.dijkstraShortestPath(sourceVertex = 0)

        // Then
        val expected = listOf(
            Node(0) to 0,
            Node(1) to 4,
            Node(2) to 12,
            Node(3) to 19,
            Node(4) to 21,
            Node(5) to 11,
            Node(6) to 9,
            Node(7) to 8,
            Node(8) to 14,
        )
        assertThat(resultPath).isEqualTo(expected)
        log.debug { "expected=$expected" }
        log.debug { "result=$resultPath" }
    }
}
