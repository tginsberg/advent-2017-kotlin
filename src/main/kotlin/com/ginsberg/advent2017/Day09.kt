/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 9
 *
 * Problem Description: http://adventofcode.com/2017/day/9
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day9/
 */
class Day09(private val input: String) {

    private val cancel = "!.".toRegex()
    private val garbage = "<.*?>".toRegex()
    private val nonGroup = "[^{}]".toRegex()

    private val cleanInput = input.replace(cancel, "")

    fun solvePart1(): Int =
        scoreGroups(cleanInput.replace(garbage, "").replace(nonGroup, "").toList())

    fun solvePart2(): Int =
        garbage.findAll(cleanInput).sumBy { it.value.length - 2 }

    private tailrec fun scoreGroups(stream: List<Char>, score: Int = 0, depth: Int = 1): Int {
        return when {
            stream.isEmpty() -> score
            stream.first() == '}' -> scoreGroups(stream.drop(1), score, depth - 1)
            else -> scoreGroups(stream.drop(1), score + depth, depth + 1)
        }
    }
}