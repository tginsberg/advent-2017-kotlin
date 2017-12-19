package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day18Test {



    @Test
    fun `Part 1 matches example`() {
        val sampleInput = listOf(
            "set a 1",
            "add a 2",
            "mul a a",
            "mod a 5",
            "snd a",
            "set a 0",
            "rcv a",
            "jgz a -1",
            "set a 1",
            "jgz a -2"
        )
        assertThat(Day18(sampleInput).solvePart1()).isEqualTo(4)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day18(resourceAsList("day_18_input.txt")).solvePart1())
            .isEqualTo(1187L)
    }

    @Test
    fun `Part 2 matches example`() {
        val sampleInput = listOf("snd 1",
            "snd 2",
            "snd p",
            "rcv a",
            "rcv b",
            "rcv c",
            "rcv d")
        assertThat(Day18(sampleInput).solvePart2()).isEqualTo(3)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day18(resourceAsList("day_18_input.txt")).solvePart2())
            .isEqualTo(5969L)
    }

}