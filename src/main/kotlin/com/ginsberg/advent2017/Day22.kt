/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 22
 *
 * Problem Description: http://adventofcode.com/2017/day/22
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day22/
 */
class Day22(input: List<String>) {

    private val grid = parseInput(input)
    private var current = Point(input.size / 2, input.first().length / 2)
    private val directions = listOf(Point(0, -1), Point(1, 0), Point(0, 1), Point(-1, 0))
    private var pointing = 0

    fun solvePart1(iterations: Int = 10_000): Int {
        var infectionsCaused = 0
        repeat(iterations) {
            if (grid.getOrDefault(current, NodeState.Clean) == NodeState.Clean) {
                infectionsCaused += 1
                grid[current] = NodeState.Infected
                pointing = left()
            } else {
                // Infected
                grid[current] = NodeState.Clean
                pointing = right()
            }
            current += directions[pointing]
        }
        return infectionsCaused
    }

    fun solvePart2(iterations: Int = 10_000_000): Int {
        var infectionsCaused = 0
        repeat(iterations) {
            when (grid.getOrDefault(current, NodeState.Clean)) {
                NodeState.Clean -> {
                    pointing = left()
                    grid[current] = NodeState.Weakened
                }
                NodeState.Weakened -> {
                    infectionsCaused += 1
                    grid[current] = NodeState.Infected
                }
                NodeState.Infected -> {
                    pointing = right()
                    grid[current] = NodeState.Flagged
                }
                NodeState.Flagged -> {
                    pointing = reverse()
                    grid[current] = NodeState.Clean
                }
            }
            current += directions[pointing]
        }
        return infectionsCaused
    }

    private fun left(): Int =
        if (pointing == 0) 3 else pointing - 1

    private fun right(): Int =
        pointing.inc() % 4

    private fun reverse(): Int =
        (pointing + 2) % 4


    private fun parseInput(input: List<String>): MutableMap<Point, NodeState> {
        val destination = mutableMapOf<Point, NodeState>()
        input.forEachIndexed { y, row ->
            row.forEachIndexed { x, char ->
                destination[Point(x, y)] = if (char == '.') NodeState.Clean else NodeState.Infected
            }
        }
        return destination
    }

    data class Point(private val x: Int, private val y: Int) {
        operator fun plus(that: Point): Point =
            Point(x + that.x, y + that.y)
    }

    enum class NodeState {
        Clean,
        Infected,
        Weakened,
        Flagged
    }
}

