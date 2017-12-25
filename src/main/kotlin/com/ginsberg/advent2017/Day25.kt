/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

/**
 * AoC 2017, Day 25
 *
 * Problem Description: http://adventofcode.com/2017/day/25
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day25/
 */
class Day25(input: List<String>) {

    private val machine = parseInput(input)

    fun solvePart1(): Int =
        machine.run()

    class Action(val write: Boolean, val move: Int, val nextState: Char)
    class MachineState(val zero: Action, val one: Action)
    class TuringMachine(private val states: Map<Char, MachineState>, private val steps: Int, startState: Char) {
        private val tape = mutableSetOf<Int>()
        private var state = states.getValue(startState)
        private var cursor = 0

        fun run(): Int {
            repeat(steps) {
                execute()
            }
            return tape.size
        }

        private fun execute() {
            if (cursor in tape) handleAction(state.one)
            else handleAction(state.zero)
        }

        private fun handleAction(action: Action) {
            if (action.write) tape.add(cursor) else tape.remove(cursor)
            cursor += action.move
            state = states.getValue(action.nextState)
        }
    }

    private fun parseInput(input: List<String>): TuringMachine {
        val initialState = input.first()[15]
        val steps = input[1].split(" ")[5].toInt()

        val stateMap = input
            .filter { it.isNotBlank() }
            .drop(2)
            .map { it.split(" ").last().dropLast(1) }
            .chunked(9)
            .map {
                it[0].first() to MachineState(
                    Action(it[2] == "1", if (it[3] == "right") 1 else -1, it[4].first()),
                    Action(it[6] == "1", if (it[7] == "right") 1 else -1, it[8].first())
                )
            }.toMap()
        return TuringMachine(stateMap, steps, initialState)
    }

}
