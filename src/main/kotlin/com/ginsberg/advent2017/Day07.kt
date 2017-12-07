/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import kotlin.math.absoluteValue

/**
 * AoC 2017, Day 7
 *
 * Problem Description: http://adventofcode.com/2017/day/7
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day7/
 */
class Day07(input: List<String>) {
    private val headOfTree: Node = parseInput(input)

    fun solvePart1(): String =
        headOfTree.name

    fun solvePart2(): Int =
        headOfTree.findImbalance()

    private fun parseInput(input: List<String>): Node {
        val nodesByName = mutableMapOf<String, Node>()
        val parentChildPairs = mutableSetOf<Pair<Node, String>>()
        val rowRegex = """\w+""".toRegex()

        input.forEach {
            val groups = rowRegex.findAll(it).toList().map { it.value }
            val node = Node(groups[0], groups[1].toInt())
            nodesByName.put(node.name, node)

            groups.drop(2).forEach {
                parentChildPairs.add(Pair(node, it))
            }
        }

        parentChildPairs.forEach { (parent, childName) ->
            with(nodesByName.getValue(childName)) {
                parent.children.add(this)
                this.parent = parent
            }
        }

        // Find the one node we have without a parent. Or freak out.
        return nodesByName.values.firstOrNull { it.parent == null }
            ?: throw IllegalStateException("No head node?!")
    }

}

data class Node(val name: String,
                private val weight: Int,
                val children: MutableList<Node> = mutableListOf(),
                var parent: Node? = null) {

    fun findImbalance(imbalance: Int = 0): Int =

        if (imbalance > 0 && childrenAreBalanced) {
            // We end when I have a positive imbalance and my children are balanced.
            weight - imbalance
        } else {
            // Find the child tree that is off.
            val subtreesByWeight = children.groupBy { it.totalWeight }

            // Find the imbalanced child tree (they will be the lone node in the list, when grouped by weight)
            val badTree = subtreesByWeight.minBy { it.value.size }?.value?.first()
                ?: throw IllegalStateException("Should not be balanced here.")

            // Recurse, passing down our imbalance. If we don't know the imbalance, calculate it.
            // Calculate the imbalance as the absolute value of the difference of all distinct weights
            badTree.findImbalance(imbalance.takeIf { it != 0 } ?: subtreesByWeight.keys.reduce { a, b -> a - b }.absoluteValue)
        }

    private val totalWeight: Int by lazy {
        weight + children.sumBy { it.totalWeight }
    }

    private val childrenAreBalanced: Boolean by lazy {
        children.map { it.totalWeight }.distinct().size == 1
    }

}
