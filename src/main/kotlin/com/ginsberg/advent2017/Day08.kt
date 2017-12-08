/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 8
 *
 * Problem Description: http://adventofcode.com/2017/day/8
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day8/
 */
class Day08(input: List<String>) {
    private val instructionRegex = """(\S+)""".toRegex()
    private val registers: MutableMap<String, Int> = mutableMapOf()
    private val instructions: List<Instruction> = parseInput(input)

    fun solvePart1(): Int {
        instructions.forEach { it.execute(registers) }
        return registers.values.max() ?: 0
    }

    fun solvePart2(): Int =
        instructions.map { it.execute(registers) }.max() ?: 0

    private fun parseInput(input: List<String>): List<Instruction> =
        // Row looks like: reg inc 123 if other > 3
        // group numbers:   ^   ^   ^   ^  ^    ^ ^
        //                  0   1   2   3  4    5 6

        input
            .map {
                val groups = instructionRegex.findAll(it).toList().map { it.value }
                val condition = createCondition(groups[5], groups[6].toInt())
                if (groups[1] == "inc")
                    Instruction(condition, groups[4], groups[0]) { it + groups[2].toInt() }
                else
                    Instruction(condition, groups[4], groups[0]) { it - groups[2].toInt() }
            }

    private fun createCondition(symbol: String, amount: Int): (Int) -> Boolean =
        when (symbol) {
            "==" -> { n -> n == amount }
            "!=" -> { n -> n != amount }
            "<" -> { n -> n < amount }
            ">" -> { n -> n > amount }
            "<=" -> { n -> n <= amount }
            ">=" -> { n -> n >= amount }
            else -> throw IllegalArgumentException("Unknown symbol: $symbol")
        }
}

class Instruction(private val condition: (Int) -> Boolean,
                  private val conditionRegister: String,
                  private val instructionRegister: String,
                  private val changer: (Int) -> Int) {

    fun execute(registers: MutableMap<String, Int>): Int {
        if (condition(registers.getOrDefault(conditionRegister, 0))) {
            registers[instructionRegister] = changer(registers.getOrDefault(instructionRegister, 0))
        }
        return registers.getOrDefault(instructionRegister, 0)
    }
}
