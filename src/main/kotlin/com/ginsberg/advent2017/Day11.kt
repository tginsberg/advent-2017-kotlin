/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import com.ginsberg.advent2017.grid.HexSpot

/**
 * AoC 2017, Day 11
 *
 * Problem Description: http://adventofcode.com/2017/day/11
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day11/
 */
class Day11(input: String) {

    private val origin = HexSpot(0, 0, 0)
    private val steps = input.split(",")

    fun solvePart1(): Int =
        steps
            .fold(origin) { spot, dir -> spot.travel(dir) }
            .distanceTo(origin)

    fun solvePart2(): Int =
        steps
            .fold(listOf(origin)) { path, dir -> path + (path.last().travel(dir)) }
            .map { it.distanceTo(origin) }
            .max() ?: 0
}
