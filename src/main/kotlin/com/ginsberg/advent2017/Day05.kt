/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 5
 *
 * Problem Description: http://adventofcode.com/2017/day/5
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day5/
 */
class Day05(stringInput: List<String>) {

    private val input: IntArray = stringInput.map { it.toInt() }.toIntArray()

    fun solvePart1(): Int =
        jump(input, { 1 })

    fun solvePart2(): Int =
        jump(input, { if (it >= 3) -1 else 1 })

    tailrec private fun jump(offsets: IntArray, mutator: (Int) -> Int, pc: Int = 0, steps: Int = 0): Int =
        if (pc < 0 || pc >= offsets.size) steps
        else {
            val nextPc = pc + offsets[pc]
            offsets[pc] += mutator(offsets[pc])
            jump(offsets, mutator, nextPc, steps.inc())
        }
}
