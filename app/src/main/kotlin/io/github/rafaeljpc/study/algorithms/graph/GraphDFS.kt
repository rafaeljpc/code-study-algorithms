package io.github.rafaeljpc.study.algorithms.graph

import io.github.oshai.kotlinlogging.KotlinLogging

class GraphDFS(
    graphSize: Int,
    edges: Array<IntArray> = emptyArray(),
) : Graph(graphSize, edges) {

    companion object {
        @JvmStatic
        private val log = KotlinLogging.logger { }
    }

    private fun dfsRecurrent(visited: BooleanArray, result: MutableList<Int>, currentNode: Int) {
        visited[currentNode] = true
        result.add(currentNode)
        for (neighbor in adjacencyList[currentNode] ?: emptyList()) {
            if (!visited[neighbor]) {
                dfsRecurrent(visited, result, neighbor)
            }
        }
    }

    fun depthFirstSearch(startNode: Int): List<Int> {
        val visited = BooleanArray(graphSize) { false }
        val result = mutableListOf<Int>()

        dfsRecurrent(visited, result, startNode)

        return result
    }

    fun allNodesDFS(): List<Int> {
        val visited = BooleanArray(graphSize) { false }
        val result = mutableListOf<Int>()

        for (i in 0 until graphSize) {
            if (!visited[i]) {
                dfsRecurrent(visited, result, i)
            }
        }

        return result
    }
}
