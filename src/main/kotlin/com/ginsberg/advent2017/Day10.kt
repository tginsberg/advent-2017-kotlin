/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 10
 *
 * Problem Description: http://adventofcode.com/2017/day/10
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day10/
 */
class Day10(input: String, part1: Boolean, ringSize: Int = 256) {

    private val magicLengths = listOf(17, 31, 73, 47, 23)
    private val lengths = if (part1) parsePart1Input(input) else parsePart2Input(input)
    private val ring = IntArray(ringSize) { it }

    fun solvePart1(): Int {
        runForLengths()
        return ring[0] * ring[1]
    }

    fun solvePart2(): String {
        runForLengths(64)
        return ring
            .toList()
            .windowed(16, 16)
            .joinToString("") { it.xor().toHex(2) }
    }

    private fun runForLengths(iterations: Int = 1) {
        var position = 0
        var skip = 0
        repeat(iterations) {
            lengths.forEach { length ->
                reverseSection(position, length)
                position = (position + length + skip) % ring.size
                skip += 1
            }
        }
    }

    private fun reverseSection(from: Int, length: Int) {
        var fromIdx = from % ring.size
        var toIdx = (fromIdx + length - 1) % ring.size
        repeat(length / 2) {
            ring.swap(fromIdx, toIdx)
            fromIdx = fromIdx.inc() % ring.size
            toIdx = toIdx.dec().takeIf { it >= 0 } ?: ring.size - 1
        }
    }

    private fun parsePart1Input(input: String): IntArray =
        input.split(",").map { it.toInt() }.toIntArray()

    private fun parsePart2Input(input: String): IntArray =
        (input.map { it.toInt() } + magicLengths).toIntArray()
}
