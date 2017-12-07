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
        val rowPattern = """^([a-z]+) \((\d+)\)(?: ->)?(.*)?$""".toRegex()
        val nodesByName = mutableMapOf<String, Node>()
        val leftToMap = mutableSetOf<Pair<String, String>>()

        input.forEach {
            val groups = rowPattern.find(it)?.groupValues
                ?: throw IllegalStateException("Should not have had a bad group")

            val node = Node(groups[1].trim(), groups[2].toInt())
            nodesByName.put(node.name, node)

            groups[3].split(",")
                .filter { it.isNotBlank() }
                .forEach { child ->
                    leftToMap.add(Pair(node.name, child.trim()))
                }
        }

        leftToMap.forEach { (parent, child) ->
            val pNode = nodesByName.getValue(parent)
            val cNode = nodesByName.getValue(child)
            pNode.children.add(cNode)
            cNode.parent = pNode
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

        if (imbalance > 0 && childrenAreBalanced()) {
            // We end when I have a positive imbalance and my children are balanced.
            weight - imbalance
        } else {
            // Find the child tree that is off.
            val subtreesByWeight = children.groupBy { it.totalWeight() }

            // Find the imbalanced child tree (they will be the lone node in the list, when grouped by weight)
            val badTree = subtreesByWeight.minBy { it.value.size }?.value?.first()
                ?: throw IllegalStateException("Should not be balanced here.")

            // Calculate the imbalanced as the absolute value of all distinct weights
            val absBadWeight = subtreesByWeight.keys.reduce { a, b -> a - b }.absoluteValue

            badTree.findImbalance(absBadWeight)
        }

    private fun totalWeight(): Int =
        weight + children.sumBy { it.totalWeight() }

    private fun childrenAreBalanced(): Boolean =
        children.map { it.totalWeight() }.distinct().size == 1

}
