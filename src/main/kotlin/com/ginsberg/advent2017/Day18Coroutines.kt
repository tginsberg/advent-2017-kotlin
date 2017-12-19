/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
import java.util.concurrent.TimeUnit

/**
 * AoC 2017, Day 18 - Coroutines version of Part 2
 *
 * Problem Description: http://adventofcode.com/2017/day/18
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day18/
 */
class Day18Coroutines(private val input: List<String>) {

    fun solvePart2(): Long = runBlocking {
        val program0Receive = Channel<Long>(Channel.UNLIMITED)
        val program1Receive = Channel<Long>(Channel.UNLIMITED)

        MachinePart2(
            registers = mutableMapOf("p" to 0L),
            send = program1Receive,
            receive = program0Receive
        ).runUntilStop(input)

        MachinePart2(
            registers = mutableMapOf("p" to 1L),
            send = program0Receive,
            receive = program1Receive
        ).runUntilStop(input).await()

    }

    data class MachinePart2(private val registers: MutableMap<String, Long> = mutableMapOf(),
                            private var pc: Int = 0,
                            private var sent: Long = 0,
                            private val send: Channel<Long>,
                            private val receive: Channel<Long>) {

        suspend fun runUntilStop(instructions: List<String>) = async {
            do {
                instructions.getOrNull(pc)?.let {
                    execute(it)
                }
            } while (pc in 0 until instructions.size)
            sent
        }

        private suspend fun execute(instruction: String) {
            val parts = instruction.split(" ")
            when (parts[0]) {
                "snd" -> {
                    send.send(registers.deref(parts[1]))
                    sent += 1
                }
                "set" -> registers[parts[1]] = registers.deref(parts[2])
                "add" -> registers[parts[1]] = registers.deref(parts[1]) + registers.deref(parts[2])
                "mul" -> registers[parts[1]] = registers.deref(parts[1]) * registers.deref(parts[2])
                "mod" -> registers[parts[1]] = registers.deref(parts[1]) % registers.deref(parts[2])
                "rcv" ->
                    try {
                        withTimeout(1, TimeUnit.SECONDS) {
                            registers[parts[1]] = receive.receive()
                        }
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
