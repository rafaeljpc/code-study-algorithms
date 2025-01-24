package io.github.rafaeljpc.study.algorithms.graph

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.rafaeljpc.study.algorithms.graph.WeightedGraph.Node
import java.util.PriorityQueue

private val log = KotlinLogging.logger { }

fun WeightedGraph.dijkstraShortestPath(sourceVertex: Int): List<Pair<Node, Int>> {
    val queue = PriorityQueue<Pair<Int, Int>>(this.numVertices, Comparator.comparingInt { it.second })
    val distances = IntArray(this.numVertices) { Int.MAX_VALUE }

    queue.add(sourceVertex to 0)
    distances[sourceVertex] = 0

    while (queue.isNotEmpty()) {
        val (minNodeId, minDistance) = queue.poll()

        for (neighbor in this.nodes[minNodeId]!!.adj.entries) {
            val v = neighbor.key
            val weight = neighbor.value
            if (distances[v] > minDistance + weight) {
                distances[v] = minDistance + weight
                queue.add(v to distances[v])
            }
        }
    }

    return distances.mapIndexed { index, distance -> Node(index) to distance }.toList()
}
