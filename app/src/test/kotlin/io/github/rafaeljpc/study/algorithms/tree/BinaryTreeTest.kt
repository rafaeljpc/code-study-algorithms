package io.github.rafaeljpc.study.algorithms.tree

import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class BinaryTreeTest {

    companion object {
        private val log = KotlinLogging.logger { }
    }


    @Test
    fun testIsNotBst() {
        // Given
        val tree = BTree()
        tree.root = BTree.Node(10)
        tree.root?.left = BTree.Node(5)
        tree.root?.right = BTree.Node(20)
        tree.root?.right?.left = BTree.Node(9)
        tree.root?.right?.right = BTree.Node(25)

        // When
        val result = tree.isBst()

        // Then
        assertThat(result).isFalse
    }

    @Test
    fun testIsBst() {
        // Given
        val tree = BTree()
        tree.root = BTree.Node(2)
        tree.root?.left = BTree.Node(1)
        tree.root?.right = BTree.Node(3)
        tree.root?.right?.right = BTree.Node(5)

        // When
        val result = tree.isBst()

        // Then
        assertThat(result).isTrue
    }

    @Test
    fun testIsBst2() {
        // Given
        val tree = BTree()
        tree.root = BTree.Node(10)
        tree.root?.left = BTree.Node(5)
        tree.root?.right = BTree.Node(20)
        tree.root?.right?.left = BTree.Node(11)
        tree.root?.right?.right = BTree.Node(25)

        // When
        val result = tree.isBst()

        // Then
        assertThat(result).isTrue
    }

    @Test
    fun `should build a BST from a sorted array`() {
        // Given
        val inputArray = listOf(5, 3, 4, 8, 7, 9, 1, 6, 2)

        // When
        val tree = BTree.fromArray(inputArray)

        // Then
        log.info { "tree = $tree" }
        assertThat(tree.isBst()).isTrue()
        assertThat(tree.root?.value).isEqualTo(5)

        assertThat(tree.root?.left?.value).isEqualTo(2)
        assertThat(tree.root?.left?.left?.value).isEqualTo(1)
        assertThat(tree.root?.left?.right?.value).isEqualTo(3)
        assertThat(tree.root?.left?.right?.right?.value).isEqualTo(4)

        assertThat(tree.root?.right?.value).isEqualTo(7)
        assertThat(tree.root?.right?.left?.value).isEqualTo(6)
        assertThat(tree.root?.right?.right?.value).isEqualTo(8)
        assertThat(tree.root?.right?.right?.right?.value).isEqualTo(9)
    }

    @Test
    fun `should build a BST from adds`() {
        // Given
        val inputArray = listOf(5, 3, 4, 8, 7, 9, 1, 6, 2)

        // When
        val tree = BTree()
        inputArray.forEach { tree.add(it) }

        // Then
        log.info { "tree = $tree" }
        assertThat(tree.isBst()).isTrue()
    }

}
