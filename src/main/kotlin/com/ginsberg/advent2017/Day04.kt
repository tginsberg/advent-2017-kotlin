/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import com.ginsberg.advent2017.Constants.WHITESPACE

/**
 * AoC 2017, Day 4
 *
 * http://adventofcode.com/2017/day/4
 */
class Day04(private val input: List<String>) {

    fun solvePart1(): Int =
        input
            .filter { isValidPart1(it) }
            .count()

    fun solvePart2(): Int =
        input
            .filter { isValidPart2(it) }
            .count()

    private fun isValidPart1(s: String): Boolean =
        s.split(WHITESPACE)
            .sorted()
            .zipWithNext()
            .count { it.first == it.second } == 0

    private fun isValidPart2(s: String): Boolean =
        s.split(WHITESPACE)
            .map { it.toCharArray().sorted().joinToString("") }
            .sorted()
            .zipWithNext()
            .count { it.first == it.second } == 0
}
