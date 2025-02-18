package io.github.rafaeljpc.study.algorithms.graph

import com.google.common.base.MoreObjects
import io.github.oshai.kotlinlogging.KotlinLogging

abstract class Graph(
    protected val graphSize: Int,
    edges: Array<IntArray> = emptyArray(),
    protected val directed: Boolean = true
) {

    companion object {
        @JvmStatic
        private val log = KotlinLogging.logger { }
    }

    protected val adjacencyList: HashMap<Int, MutableList<Int>> = HashMap(graphSize)

    init {
        this.addEdges(edges)
    }

    fun addEdge(node1: Int, node2: Int) {
        adjacencyList[node1]?.add(node2) ?: adjacencyList.put(node1, mutableListOf(node2))
    }

    fun addEdges(edges: Array<IntArray>) {
        for (edge in edges) {
            addEdge(edge[0], edge[1])
            if (!directed) {
                addEdge(edge[1], edge[0])
            }
        }
    }

    override fun toString(): String = MoreObjects.toStringHelper(this::class)
        .add("size", graphSize)
        .add("adj", adjacencyList)
        .toString()
}
