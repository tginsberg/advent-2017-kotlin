package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day06Test {


    @Test
    fun `Part 1 matches example`() {
        val sample = "0 2 7 0"
        assertThat(Day06(sample).solvePart1()).isEqualTo(5)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day06(resourceAsString("day_6_input.txt")).solvePart1()).isEqualTo(6681)
    }

    @Test
    fun `Part 2 matches example`() {
        val sample = "0 2 7 0"
        assertThat(Day06(sample).solvePart2()).isEqualTo(4)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day06(resourceAsString("day_6_input.txt")).solvePart2()).isEqualTo(2392)
    }
}