package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day18CoroutinesTest {


    @Test
    fun `Part 2 matches example`() {
        val sampleInput = listOf("snd 1",
            "snd 2",
            "snd p",
            "rcv a",
            "rcv b",
            "rcv c",
            "rcv d")
        assertThat(Day18Coroutines(sampleInput).solvePart2()).isEqualTo(3)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day18Coroutines(resourceAsList("day_18_input.txt")).solvePart2())
            .isEqualTo(5969L)
    }

}