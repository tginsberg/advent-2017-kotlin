/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import com.ginsberg.advent2017.Constants.WHITESPACE

/**
 * AoC 2017, Day 4
 *
 * Problem Description: http://adventofcode.com/2017/day/4
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day4/
 */
class Day04(private val input: List<String>) {

    fun solvePart1(): Int =
        input
            .map { it.split(WHITESPACE) }
            .count { it.size == it.toSet().size }

    fun solvePart2(): Int =
        input
            .map { it.split(WHITESPACE).map { it.toCharArray().sorted().joinToString("") } }
            .count { it.size == it.toSet().size }

}
