/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 17
 *
 * Problem Description: http://adventofcode.com/2017/day/17
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day17/
 */
class Day17(input: String) {

    private val step = input.toInt()

    fun solvePart1(): Int {
        var current = 0
        val memory = mutableListOf(0)
        (1..2017).forEach {
            current = ((current + step) % it) + 1
            memory.add(current, it)
        }
        return memory[current.inc() % memory.size]
    }

    fun solvePart2(): Int {
        var current = 0
        var oneSlot = 0
        (1..50_000_000).forEach {
            current = ((current + step) % it) + 1
            if (current == 1) oneSlot = it
        }
        return oneSlot
    }
}

