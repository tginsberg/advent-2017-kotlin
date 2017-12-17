package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day14Test {

    private val sampleInput = "flqrgnkx"

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day14(sampleInput).solvePart1()).isEqualTo(8108)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day14(resourceAsString("day_14_input.txt")).solvePart1())
            .isEqualTo(8222)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day14(sampleInput).solvePart2()).isEqualTo(1242)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day14(resourceAsString("day_14_input.txt")).solvePart2())
            .isEqualTo(1086)
    }

}