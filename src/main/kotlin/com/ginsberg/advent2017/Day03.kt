/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import java.lang.Math.abs
import kotlin.math.ceil
import kotlin.math.sqrt

/**
 * AoC 2017, Day 3
 *s
 * Problem Description: http://adventofcode.com/2017/day/3
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day3/
 */
class Day03(input: String) {

    private val target = input.toInt()

    fun solvePart1(): Int {
        val sideLength = lengthOfSideWith(target)
        val stepsToRingFromCenter = (sideLength - 1) / 2
        val midpoints = midpointsForSideLength(sideLength)
        return stepsToRingFromCenter + midpoints.map { abs(target - it) }.min()!!
    }

    fun solvePart2(): Int =
        Grid(lengthOfSideWith(target))
            .generateSpots()
            .first { it > target }

    private fun lengthOfSideWith(n: Int): Int =
        ceil(sqrt(n.toDouble())).toInt().let {
            if (it.isOdd()) it
            else it + 1
        }

    private fun midpointsForSideLength(sideLength: Int): List<Int> {
        val highestOnSide = sideLength * sideLength
        val offset = ((sideLength - 1) / 2.0).toInt()
        return (0..3).map {
            highestOnSide - (offset + (it * sideLength.dec()))
        }
    }

}

class Grid(size: Int) {
    private var pointer: Pair<Int, Int> = Pair(size / 2, size / 2)
    private var direction: Direction = East
    private val grid: List<IntArray> = (0 until size).map { IntArray(size) }.apply {
        this[pointer.first][pointer.second] = 1
    }

    fun generateSpots(): Sequence<Int> =
        generateSequence(1) {
            pointer = direction.move(pointer)
            grid[pointer.first][pointer.second] = sumNeighbors()
            // Turn if we can.
            direction = if (atSpot(direction.turn.move(pointer)) == 0) direction.turn else direction
            atSpot(pointer)
        }

    private fun sumNeighbors(): Int =
        (pointer.first - 1..pointer.first + 1).map { x ->
            (pointer.second - 1..pointer.second + 1).map { y ->
                atSpot(x, y)
            }
        }.flatten()
            .filterNotNull()
            .sum()

    private fun atSpot(spot: Pair<Int, Int>): Int? =
        atSpot(spot.first, spot.second)

    private fun atSpot(x: Int, y: Int): Int? =
        if (x in (0 until grid.size) && y in (0 until grid.size)) grid[x][y]
        else null

}

sealed class Direction {
    abstract fun move(point: Pair<Int, Int>): Pair<Int, Int>
    abstract val turn: Direction
}

object East : Direction() {
    override fun move(point: Pair<Int, Int>): Pair<Int, Int> = Pair(point.first + 1, point.second)
    override val turn = North
}

object West : Direction() {
    override fun move(point: Pair<Int, Int>): Pair<Int, Int> = Pair(point.first - 1, point.second)
    override val turn = South
}

object North : Direction() {
    override fun move(point: Pair<Int, Int>): Pair<Int, Int> = Pair(point.first, point.second + 1)
    override val turn = West
}

object South : Direction() {
    override fun move(point: Pair<Int, Int>): Pair<Int, Int> = Pair(point.first, point.second - 1)
    override val turn = East
}
