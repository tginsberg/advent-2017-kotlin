/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 23
 *
 * Problem Description: http://adventofcode.com/2017/day/23
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day23/
 */
class Day23(private val input: List<String>) {

    fun solvePart1(): Long =
        Machine().runUntilStop(input).debug["mul"] ?: 0

    fun solvePart2(): Int {
        val b = input.first().split(" ")[2].toInt() * 100 + 100000
        return (b.. b+17000 step 17).count {
            !it.toBigInteger().isProbablePrime(2)
        }
    }

    data class Machine(private val registers: MutableMap<String, Long> = mutableMapOf(),
                       private var pc: Int = 0,
                       val debug: MutableMap<String, Long> = mutableMapOf()) {

        fun runUntilStop(instructions: List<String>): Machine {
            do {
                instructions.getOrNull(pc)?.let {
                    execute(it)
                }
            } while (pc in 0 until instructions.size)
            return this
        }

        private fun execute(instruction: String) {
            val parts = instruction.split(" ")
            debug[parts[0]] = debug.deref(parts[0]) + 1
            when (parts[0]) {
                "set" -> registers[parts[1]] = registers.deref(parts[2])
                "sub" -> registers[parts[1]] = registers.deref(parts[1]) - registers.deref(parts[2])
                "mul" -> registers[parts[1]] = registers.deref(parts[1]) * registers.deref(parts[2])
                "jnz" -> if (registers.deref(parts[1]) != 0L) {
                    pc += registers.deref(parts[2]).toInt().dec()
                }
                else -> throw IllegalArgumentException("No such instruction ${parts[0]}")
            }
            pc += 1
        }
    }

}

