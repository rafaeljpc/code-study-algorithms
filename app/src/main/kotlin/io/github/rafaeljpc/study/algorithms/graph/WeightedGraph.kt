package io.github.rafaeljpc.study.algorithms.graph

import com.google.common.base.MoreObjects

class WeightedGraph(
    val numVertices: Int,
    edges: List<Edge> = emptyList(),
    val directed: Boolean = false,
) {
    data class Edge(val from: Int, val to: Int, val weight: Int)
    data class Node(val id: Int) {
        var adj: MutableMap<Int, Int> = mutableMapOf()
            private set

        override fun toString(): String = MoreObjects.toStringHelper(this)
            .add("id", id)
            .add("adj", adj)
            .toString()

    }

    val nodes = HashMap<Int, Node>(numVertices)

    init {
        this.addEdges(edges)
    }

    fun addEdge(edge: Edge) {
        if (!nodes.containsKey(edge.from)) {
            nodes[edge.from] = Node(edge.from)
        }
        if (!nodes.containsKey(edge.to)) {
            nodes[edge.to] = Node(edge.to)
        }
        nodes[edge.from]!!.apply {
            this.adj[edge.to] = edge.weight

        }
        if (!directed) {
            nodes[edge.to]!!.apply {
                this.adj[edge.from] = edge.weight
            }
        }
    }

    fun addEdges(edges: List<Edge>) {
        edges.forEach { addEdge(it) }
    }

    override fun toString(): String = MoreObjects.toStringHelper(this)
        .add("numVertices", numVertices)
        .add("nodes", nodes.entries.joinToString(",\n", "[", "]"))
        .toString()
}
