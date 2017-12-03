/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 2
 *
 * http://adventofcode.com/2017/day/2
 */
class Day02(stringInput: List<String>) {

    private val input: List<List<Int>> = parseInput(stringInput)

    fun solvePart1(): Int =
        input
            .map { it.sorted() }
            .sumBy { it.last() - it.first() }

    fun solvePart2(): Int =
        input
            .map { findDivisiblePairForRow(it) }
            .sumBy { it.first / it.second }

    // Given a row, generate all possible Pair<Int,Int>, filter out
    // pairs matched with self, and filter down to the first one
    // that has a divisible pair.
    private fun findDivisiblePairForRow(row: List<Int>): Pair<Int, Int> =
        row
            .flatMap { x -> row.map { Pair(x, it) } }
            .filter { it.first != it.second }
            .first { it.first % it.second == 0 }

    private fun parseInput(s: List<String>): List<List<Int>> =
        s.map { it.split(Constants.WHITESPACE).map { it.toInt() } }
}
