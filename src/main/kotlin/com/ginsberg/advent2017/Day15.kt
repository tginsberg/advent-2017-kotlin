/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 15
 *
 * Problem Description: http://adventofcode.com/2017/day/15
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day15/
 */
class Day15(input: List<String>) {

    private val notNumbers = """[^\d]""".toRegex()
    private val generatorA = generator(input[0].replace(notNumbers, "").toLong(), 16807)
    private val generatorB = generator(input[1].replace(notNumbers, "").toLong(), 48271)

    fun solvePart1(pairs: Int = 40_000_000): Int =
        generatorA
            .zip(generatorB)
            .take(pairs)
            .count { it.first == it.second }

    fun solvePart2(pairs: Int = 5_000_000): Int =
        generatorA.filter { it % 4 == 0 }
            .zip(generatorB.filter { it % 8 == 0 })
            .take(pairs)
            .count { it.first == it.second }

    private fun generator(start: Long, factor: Long, divisor: Long = 2147483647): Sequence<Short> =
        generateSequence((start * factor) % divisor) { past ->
            (past * factor) % divisor
        }.map { it.toShort() }

}
