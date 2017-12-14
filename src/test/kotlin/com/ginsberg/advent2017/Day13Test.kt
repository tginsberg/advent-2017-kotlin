package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day13Test {

    private val sampleInput = listOf(
        "0: 3",
        "1: 2",
        "4: 4",
        "6: 4")

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day13(sampleInput).solvePart1()).isEqualTo(24)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day13(resourceAsList("day_13_input.txt")).solvePart1())
            .isEqualTo(1476)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day13(sampleInput).solvePart2()).isEqualTo(10)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day13(resourceAsList("day_13_input.txt")).solvePart2())
            .isEqualTo(3937334)
    }

}