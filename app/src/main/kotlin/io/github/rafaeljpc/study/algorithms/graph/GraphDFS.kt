package io.github.rafaeljpc.study.algorithms.graph

import com.google.common.base.MoreObjects
import io.github.oshai.kotlinlogging.KotlinLogging

class GraphDFS(
    private val graphSize: Int,
    edges: Array<IntArray> = emptyArray(),
) {
    companion object {
        @JvmStatic
        private val log = KotlinLogging.logger { }
    }

    private val adjacencyList: HashMap<Int, MutableList<Int>> = HashMap(graphSize)

    init {
        this.addEdges(edges)
    }

    fun addEdge(node1: Int, node2: Int) {
        adjacencyList[node1]?.add(node2) ?: adjacencyList.put(node1, mutableListOf(node2))
    }

    fun addEdges(edges: Array<IntArray>) {
        for (edge in edges) {
            addEdge(edge[0], edge[1])
        }
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

    override fun toString(): String = MoreObjects.toStringHelper(this::class)
        .add("size", graphSize)
        .add("adj", adjacencyList)
        .toString()

    fun allNodes(): List<Int> {
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
