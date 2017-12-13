/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 12
 *
 * Problem Description: http://adventofcode.com/2017/day/12
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day12/
 */
class Day12(input: List<String>) {

    private val splitter = """(\d+)""".toRegex()
    private val nodes: Map<Int, Set<Int>> = parseInput(input)

    fun solvePart1(): Int =
        getReachableFrom(0).size

    fun solvePart2(): Int {
        val seen = mutableSetOf<Int>()
        return nodes.keys
            .asSequence()
            .filter { it !in seen }
            .map {
                getReachableFrom(it).apply {
                    seen.addAll(this)
                }
            }
            .count()
    }

    private fun getReachableFrom(from: Int, seen: MutableSet<Int> = mutableSetOf()): Set<Int> {
        if(from !in seen) {
            seen.add(from)
            nodes.getValue(from).forEach { getReachableFrom(it, seen) }
        }
        return seen
    }

    private fun parseInput(input: List<String>): Map<Int, Set<Int>> =
        input
            .map { splitter.findAll(it) }
            .map { it.map { it.value.toInt() } }
            .associate { it.first() to it.drop(1).toSet() }
}