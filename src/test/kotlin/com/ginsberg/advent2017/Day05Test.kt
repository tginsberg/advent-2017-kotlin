package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day05Test {


    @Test
    fun `Part 1 matches example`() {
        val sample = listOf("0", "3", "0", "1", "-3")
        assertThat(Day05(sample).solvePart1()).isEqualTo(5)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day05(resourceAsList("day_5_input.txt")).solvePart1()).isEqualTo(381680)
    }

    @Test
    fun `Part 2 matches example`() {
        val sample = listOf("0", "3", "0", "1", "-3")
        assertThat(Day05(sample).solvePart2()).isEqualTo(10)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day05(resourceAsList("day_5_input.txt")).solvePart2()).isEqualTo(29717847)
    }
}