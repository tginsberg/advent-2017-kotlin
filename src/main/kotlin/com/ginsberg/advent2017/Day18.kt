/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import java.util.concurrent.BlockingQueue
import java.util.concurrent.CompletableFuture
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.TimeUnit

/**
 * AoC 2017, Day 18
 *
 * Problem Description: http://adventofcode.com/2017/day/18
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day18/
 */
class Day18(private val input: List<String>) {

    fun solvePart1(): Long =
        MachinePart1().runUntilStop(input)

    fun solvePart2(): Long {
        val program0Receive = LinkedBlockingDeque<Long>()
        val program1Receive = LinkedBlockingDeque<Long>()

        MachinePart2(
            registers = mutableMapOf("p" to 0L),
            send = program1Receive,
            receive = program0Receive
        ).runUntilStop(input)

        return MachinePart2(
            registers = mutableMapOf("p" to 1L),
            send = program0Receive,
            receive = program1Receive
        ).runUntilStop(input).get()
    }

    data class MachinePart1(private val registers: MutableMap<String, Long> = mutableMapOf(),
                            private var pc: Int = 0,
                            private var sound: Long = 0,
                            private var recovered: Long = 0) {
        fun runUntilStop(instructions: List<String>): Long {
            do {
                instructions.getOrNull(pc)?.let {
                    execute(it)
                }
            } while (pc in 0 until instructions.size && recovered == 0L)
            return recovered
        }

        private fun execute(instruction: String) {
            val parts = instruction.split(" ")
            when (parts[0]) {
                "snd" -> sound = registers.deref(parts[1])
                "set" -> registers[parts[1]] = registers.deref(parts[2])
                "add" -> registers[parts[1]] = registers.deref(parts[1]) + registers.deref(parts[2])
                "mul" -> registers[parts[1]] = registers.deref(parts[1]) * registers.deref(parts[2])
                "mod" -> registers[parts[1]] = registers.deref(parts[1]) % registers.deref(parts[2])
                "rcv" -> if (registers.deref(parts[1]) != 0L) {
                    recovered = sound
                }
                "jgz" -> if (registers.deref(parts[1]) > 0L) {
                    pc += registers.deref(parts[2]).toInt().dec()
                }
                else -> throw IllegalArgumentException("No such instruction ${parts[0]}")
            }
            pc += 1
        }
    }

    data class MachinePart2(private val registers: MutableMap<String, Long> = mutableMapOf(),
                            private var pc: Int = 0,
                            private var sent: Long = 0,
                            private val send: BlockingQueue<Long>,
                            private val receive: BlockingQueue<Long>) {

        fun runUntilStop(instructions: List<String>): CompletableFuture<Long> =
            CompletableFuture.supplyAsync {
                do {
                    instructions.getOrNull(pc)?.let {
                        execute(it)
                    }
                } while (pc in 0 until instructions.size)
                sent
            }

        private fun execute(instruction: String) {
            val parts = instruction.split(" ")
            when (parts[0]) {
                "snd" -> {
                    send.put(registers.deref(parts[1]))
                    sent += 1
                }
                "set" -> registers[parts[1]] = registers.deref(parts[2])
                "add" -> registers[parts[1]] = registers.deref(parts[1]) + registers.deref(parts[2])
                "mul" -> registers[parts[1]] = registers.deref(parts[1]) * registers.deref(parts[2])
                "mod" -> registers[parts[1]] = registers.deref(parts[1]) % registers.deref(parts[2])
                "rcv" ->
                    try {
                        registers[parts[1]] = receive.poll(1, TimeUnit.SECONDS)
                    } catch (e: Exception) {
                        pc = -2 // Die
                    }
                "jgz" ->
                    if (registers.deref(parts[1]) > 0L) {
                        pc += registers.deref(parts[2]).toInt().dec()
                    }
                else -> throw IllegalArgumentException("No such instruction ${parts[0]}")
            }
            pc += 1
        }
    }
}
