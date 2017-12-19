/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 19
 *
 * Problem Description: http://adventofcode.com/2017/day/19
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day19/
 */
class Day19(private val input: List<String>) {

    private val grid = input.map { it.toCharArray() }
    private val directions = listOf(
        Coordinate(0, 1),
        Coordinate(0, -1),
        Coordinate(1, 0),
        Coordinate(-1, 0)
    )

    fun solvePart1(): String =
        traverse(Coordinate(input[0].indexOf("|"), 0), Coordinate(0, 1)).second

    fun solvePart2(): Int =
        traverse(Coordinate(input[0].indexOf("|"), 0), Coordinate(0, 1)).first

    private tailrec fun traverse(location: Coordinate,
                                 direction: Coordinate,
                                 seen: List<Char> = emptyList(),
                                 steps: Int = 0): Pair<Int, String> =
        if (grid.at(location) == ' ') Pair(steps, seen.joinToString(""))
        else {
            when (grid.at(location)) {
                in 'A'..'Z' -> traverse(location + direction, direction, seen + grid.at(location), steps.inc())
                '+' -> {
                    val turn = turn(location, direction)
                    traverse(location + turn, turn, seen, steps.inc())
                }
                else -> traverse(location + direction, direction, seen, steps.inc())
            }
        }

    private fun turn(location: Coordinate, direction: Coordinate) =
        directions
            .filter { it != direction }
            .filter { it != !direction }
            .first { grid.at(location + it) != ' ' }

    private fun List<CharArray>.at(coordinate: Coordinate): Char =
        this[coordinate.y][coordinate.x]

    data class Coordinate(val x: Int, val y: Int) {
        operator fun plus(that: Coordinate) = Coordinate(x + that.x, y + that.y)
        operator fun not() = Coordinate(-x, -y)
    }

}

