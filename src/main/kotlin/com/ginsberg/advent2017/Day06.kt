/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 6
 *
 * Problem Description: http://adventofcode.com/2017/day/6
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day6/
 */
class Day06(stringInput: String) {

    private val input: IntArray = stringInput.split(Constants.WHITESPACE).map { it.toInt() }.toIntArray()

    fun solvePart1(): Int =
        reallocate(input) { map, _ ->
            map.size
        }

    fun solvePart2(): Int =
        reallocate(input) { map, key ->
            (map.size) - map.getValue(key)
        }

    tailrec private fun reallocate(memory: IntArray,
                                   seen: Map<String, Int> = mutableMapOf(),
                                   answer: (Map<String, Int>, String) -> Int): Int {
        val hash = memory.joinToString()
        return if (hash in seen) answer(seen, hash)
        else {
            val (index, amount) = memory.withIndex().maxBy { it.value }!!
            memory[index] = 0
            repeat(amount) { i ->
                val idx = (index + i + 1) % memory.size
                memory[idx] += 1
            }
            reallocate(memory, seen + (hash to seen.size), answer)
        }
    }
}