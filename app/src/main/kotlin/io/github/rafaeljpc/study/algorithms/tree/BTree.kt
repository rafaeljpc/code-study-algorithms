package io.github.rafaeljpc.study.algorithms.tree

import com.google.common.base.MoreObjects
import com.google.common.base.Objects
import java.util.LinkedList
import java.util.Queue

class BTree {

    var root: Node? = null

    class Node(
        val value: Int,
        var left: Node? = null,
        var right: Node? = null,
    ) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            return Objects.equal(this.value, (other as Node).value)
        }

        override fun hashCode(): Int = Objects.hashCode(this.value)

        override fun toString(): String = MoreObjects.toStringHelper(this)
            .omitNullValues()
            .add("value", value)
            .add("left", left)
            .add("right", right)
            .toString()
    }


    fun isBst(): Boolean {
        var curr = this.root
        var pre: Node? = null
        var preValue = Int.MIN_VALUE

        while (curr != null) {
            if (curr.left == null) {
                if (curr.value <= preValue) {
                    return false
                }
                preValue = curr.value
                curr = curr.right
            } else {
                pre = curr.left
                while (pre?.right != null && pre.right != curr) {
                    pre = pre.right
                }
                if (pre?.right == null) {
                    pre?.right = curr
                    curr = curr.left
                } else {
                    pre.right = null

                    if (curr.value <= preValue) {
                        return false
                    }
                    preValue = curr.value
                    curr = curr.right
                }
            }
        }

        return true
    }

    fun add(value: Int) {
        val temp = Node(value)

        if (this.root == null) {
            this.root = temp
        }

        var parent: Node? = null
        var curr = this.root
        while (curr != null) {
            parent = curr
            if (curr.value > value) { // add left
                curr = curr.left
            } else if (curr.value < value) { // add right
                curr = curr.right
            } else { // already exists
                return
            }
        }

        if (parent?.value!! > value) {
            parent.left = temp
        } else {
            parent.right = temp
        }
    }

    override fun toString(): String {
        return "BTree(root=$root)"
    }


    companion object {
        private data class SortData(
            val node: Node,
            val start: Int,
            val end: Int
        )

        fun fromArray(array: List<Int>): BTree {
            val tree = BTree()
            val sortedArray = array.sorted()
            val n = sortedArray.size

            if (n == 0) {
                return tree
            }

            var mid = (n - 1) / 2
            tree.root = Node(sortedArray[mid])

            val queue = LinkedList<SortData>() as Queue<SortData>
            queue.add(SortData(tree.root!!, 0, n - 1))

            while (queue.isNotEmpty()) {
                val data = queue.poll()

                val curr = data.node
                val start = data.start
                val end = data.end

                val index = start + (end - start) / 2

                if (start < index) { // insert left
                    mid = start + (index - 1 - start) / 2
                    curr.left = Node(sortedArray[mid])
                    queue.add(SortData(curr.left!!, start, index - 1))
                }

                if (end > index) { // insert right
                    mid = index + 1 + (end - index - 1) / 2
                    curr.right = Node(sortedArray[mid])
                    queue.add(SortData(curr.right!!, index + 1, end))
                }
            }

            return tree
        }
    }
}
