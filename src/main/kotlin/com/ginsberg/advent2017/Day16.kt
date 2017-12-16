/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 16
 *
 * Problem Description: http://adventofcode.com/2017/day/16
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day16/
 */
class Day16(input: String, private val programNames: String = "abcdefghijklmnop") {

    private val initialState: CharArray = programNames.toCharArray()
    private val instructions: List<Dance> = parseInput(input)

    fun solvePart1(): String =
        executeInstructions()

    tailrec fun solvePart2(memory: Map<String, Int> = mapOf(), loopNumber: Int = 0, hash: String = programNames): String {
        return if (hash in memory) {
            // We found it!
            val cycleStart = memory.getValue(hash)
            val offset = (1_000_000_000 % (loopNumber - cycleStart)) - cycleStart
            memory.entries.first { it.value == offset }.key
        } else {
            solvePart2(memory + (hash to loopNumber), loopNumber.inc(), executeInstructions(hash.toCharArray()))
        }
    }

    private fun executeInstructions(startState: CharArray = initialState): String =
        instructions.fold(startState) { carry, next -> evaluate(carry, next) }.joinToString("")

    private fun evaluate(programs: CharArray, instruction: Dance): CharArray =
        when (instruction) {
            is Spin -> {
                (programs.takeLast(instruction.amount) + programs.dropLast(instruction.amount)).toCharArray()
            }
            is Exchange ->
                programs.swap(instruction.left, instruction.right)
            is Partner ->
                programs.swap(programs.indexOf(instruction.left), programs.indexOf(instruction.right))
        }

    private fun parseInput(input: String): List<Dance> =
        input
            .split(",")
            .map { it.trim() }
            .map {
                when (it.first()) {
                    's' -> Spin(it.drop(1).toInt())
                    'x' -> {
                        val (a, b) = it.drop(1).split("/").map { it.toInt() }
                        Exchange(a, b)
                    }
                    'p' -> {
                        Partner(it[1], it[3])
                    }
                    else -> throw IllegalArgumentException("Bad input: $it")
                }
            }
}

sealed class Dance
class Spin(val amount: Int) : Dance()
class Exchange(val left: Int, val right: Int) : Dance()
class Partner(val left: Char, val right: Char) : Dance()
