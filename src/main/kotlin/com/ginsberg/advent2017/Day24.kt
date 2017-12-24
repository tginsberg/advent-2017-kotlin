/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 24
 *
 * Problem Description: http://adventofcode.com/2017/day/24
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day24/
 */
class Day24(input: List<String>) {

    private val components = parseInput(input)

    fun solvePart1(): Int =
        makeBridges(components).maxBy { it.strength() }?.strength() ?: 0

    fun solvePart2(): Int =
        makeBridges(components)
            .maxWith(
                compareBy({ it.size }, { it.strength() })
            )?.strength() ?: 0

    private fun makeBridges(components: Set<Component>,
                            bridge: List<Component> = emptyList(),
                            port: Int = 0): List<List<Component>> {
        val compatible = components.filter { it.fits(port) }
        return when (compatible.size) {
            0 -> listOf(bridge)
            else ->
                compatible.flatMap { pick ->
                    makeBridges(
                        components - pick,
                        bridge + pick,
                        pick.opposite(port)
                    )
                }
        }
    }

    private fun parseInput(input: List<String>): Set<Component> =
        input.map { it.split("/") }.map { Component(it[0].toInt(), it[1].toInt()) }.toSet()

    data class Component(private val x: Int, private val y: Int) {
        val strength = x + y
        fun fits(port: Int): Boolean = x == port || y == port
        fun opposite(port: Int): Int = if (port == x) y else x
    }

    private fun List<Component>.strength(): Int = this.sumBy { it.strength }

}
