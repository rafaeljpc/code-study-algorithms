package io.github.rafaeljpc.study.algorithms.graph

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.LinkedList
import java.util.Queue

class GraphBFS(
    graphSize: Int,
    edges: Array<IntArray> = emptyArray(),
    uniDirected: Boolean = true
) : Graph(graphSize, edges, uniDirected) {

    companion object {
        @JvmStatic
        private val log = KotlinLogging.logger { }
    }

    fun bfsWithDisconnected(): List<Int> {
        val visited = BooleanArray(graphSize) { false }
        val result = mutableListOf<Int>()

        for (i in 0..adjacencyList.size) {
            if (!visited[i]) {
                val reached = bfs(i)
                result += reached
                reached.forEach {
                    visited[it] = true
                }
            }
        }

        return result
    }

    fun bfs(startNode: Int): List<Int> {
        val visited = BooleanArray(graphSize) { false }
        val queue = LinkedList<Int>() as Queue<Int>

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

    fun isCyclic(): Boolean {
        val inDegree = IntArray(graphSize)
        val queue = LinkedList<Int>() as Queue<Int>
        var visited = 0

        for (u in 0..<graphSize) {
            for (v in adjacencyList[u] ?: emptyList()) {
                inDegree[v]++
            }
        }

        log.debug { "inDegree=${inDegree.joinToString(", ", "[", "]")}" }

        for (u in 0..<graphSize) {
            if (inDegree[u] == 0) {
                queue.add(u)
            }
        }

        while (!queue.isEmpty()) {
            val currentNode = queue.poll()
            visited++

            for (v in adjacencyList[currentNode] ?: emptyList()) {
                inDegree[v]--
                if (inDegree[v] == 0) {
                    queue.add(v)
                }
            }
            log.debug { "inDegree=${inDegree.joinToString(", ", "[", "]")} visited=$visited" }

        }

        log.debug { "visited=$visited" }
        return visited != graphSize
    }
}
