/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 1
 *
 * Problem Description: http://adventofcode.com/2017/day/1
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day1/
 */
class Day01(private val input: String) {

    fun solvePart1(): Int =
        (input + input[0])   // Circular list, re-add [0] to the end so they pair up.
            .zipWithNext()
            .filter { it.first == it.second }
            .map { it.first.asDigit() }
            .sum()

    fun solvePart2(): Int {
        val half = input.length / 2
        return input
            .subSequence(0, half)
            .filterIndexed { i, c -> c == input[i + half] }
            .map { it.asDigit() * 2 }
            .sum()
    }

}
