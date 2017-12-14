/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 13
 *
 * Problem Description: http://adventofcode.com/2017/day/13
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day13/
 */
class Day13(input: List<String>) {

    data class Layer(private val depth: Int, private val range: Int) {
        fun caughtAt(time: Int): Boolean =
            (time + depth) % ((range - 1) * 2) == 0

        val severity: Int =
            depth * range
    }

    private val layers = parseInput(input)

    fun solvePart1(): Int =
        layers
            .filter { it.caughtAt(0) }
            .sumBy { it.severity }


    fun solvePart2(): Int =
        generateSequence(0, Int::inc)
            .filter { time ->
                layers.none { it.caughtAt(time) }
            }
            .first()

    private fun parseInput(input: List<String>): List<Layer> =
        input
            .map { it.split(": ") }
            .map { Layer(it[0].toInt(), it[1].toInt()) }

}
