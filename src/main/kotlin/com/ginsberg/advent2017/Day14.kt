/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import com.ginsberg.advent2017.hash.KnotHash
import java.math.BigInteger

/**
 * AoC 2017, Day 14
 *
 * Problem Description: http://adventofcode.com/2017/day/14
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day14/
 */
class Day14(input: String) {

    private val binaryStrings = parseInput(input)
    private val grid by lazy { stringsToGrid() }

    fun solvePart1(): Int =
        binaryStrings.sumBy { it.count { it == '1' } }

    fun solvePart2(): Int {
        var groups = 0
        grid.forEachIndexed { x, row ->
            row.forEachIndexed { y, spot ->
                if (spot == 1) {
                    groups += 1
                    markNeighbors(x, y)
                }
            }
        }
        return groups
    }

    private fun markNeighbors(x: Int, y: Int) {
        if (grid[x][y] == 1) {
            grid[x][y] = 0
            neighborsOf(x, y).forEach {
                markNeighbors(it.first, it.second)
            }
        }
    }

    private fun neighborsOf(x: Int, y: Int): List<Pair<Int, Int>> =
        listOf(Pair(x - 1, y), Pair(x + 1, y), Pair(x, y - 1), Pair(x, y + 1))
            .filter { it.first in 0..127 }
            .filter { it.second in 0..127 }

    private fun stringsToGrid(): List<IntArray> =
        binaryStrings
            .map { s -> s.map { it.asDigit() } }
            .map { it.toIntArray() }

    private fun parseInput(input: String): List<String> =
        (0..127)
            .map { KnotHash.hash("$input-$it") }
            .map { BigInteger(it, 16).toString(2).padStart(128, '0') }
}
