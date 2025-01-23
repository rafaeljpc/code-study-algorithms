package io.github.rafaeljpc.study.algorithms.graph

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.LinkedList

class GraphBFS(
    graphSize: Int,
    edges: Array<IntArray> = emptyArray(),
) : Graph(graphSize, edges) {

    companion object {
        @JvmStatic
        private val log = KotlinLogging.logger { }
    }

    fun bfs(startNode: Int): List<Int> {
        val visited = BooleanArray(graphSize)
        val queue = LinkedList<Int>()

        val result = mutableListOf<Int>()

        visited[startNode] = true
        queue.add(startNode)

        while (!queue.isEmpty()) {
            val currentNode = queue.poll()

            result.add(currentNode)

            for (x in adjacencyList[currentNode] ?: emptyList()) {
                if (!visited[x]) {
                    visited[x] = true
                    queue.add(x)
                }
            }
        }

        return result
    }
}
