/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import com.ginsberg.advent2017.grid.FractalGrid
import com.ginsberg.advent2017.grid.join

/**
 * AoC 2017, Day 21
 *
 * Problem Description: http://adventofcode.com/2017/day/21
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day21/
 */
class Day21(input: List<String>) {

    private val rowSplit = " => ".toRegex()
    private val transforms: Map<FractalGrid, FractalGrid> = parseInput(input)
    private val startGrid = FractalGrid(".#./..#/###")

    fun solve(iterations: Int): Int {
        var grid = startGrid
        repeat(iterations) {
            val splits = grid.split()
            val next = splits.map { transforms.getValue(it) }
            grid = next.join()
        }
        return grid.toString().count { it == '#' }
    }


    private fun parseInputRow(input: String): Pair<FractalGrid, FractalGrid> =
        input.split(rowSplit)
            .map { FractalGrid(it) }
            .let { it.first() to it.last() }


    private fun parseInput(input: List<String>): Map<FractalGrid, FractalGrid> =
        input.map { parseInputRow(it) }.flatMap { pair ->
            pair.first.combinations().map { combo ->
                combo to pair.second
            }
        }.toMap()

}
