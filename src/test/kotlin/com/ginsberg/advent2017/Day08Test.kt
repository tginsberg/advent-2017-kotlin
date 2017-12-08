package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day08Test {

    private val sampleInput = listOf(
        "b inc 5 if a > 1",
        "a inc 1 if b < 5",
        "c dec -10 if a >= 1",
        "c inc -20 if c == 10"
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day08(sampleInput).solvePart1()).isEqualTo(1)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day08(resourceAsList("day_8_input.txt")).solvePart1()).isEqualTo(6611)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day08(sampleInput).solvePart2()).isEqualTo(10)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day08(resourceAsList("day_8_input.txt")).solvePart2()).isEqualTo(6619)
    }
}