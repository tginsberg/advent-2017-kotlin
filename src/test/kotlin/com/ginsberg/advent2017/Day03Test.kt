package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day03Test {


    @Test
    fun `Part 1 matches example`() {
        assertThat(Day03("17").solvePart1()).isEqualTo(4)
        assertThat(Day03("1024").solvePart1()).isEqualTo(31)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day03(resourceAsString("day_3_input.txt")).solvePart1()).isEqualTo(326)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day03("747").solvePart2()).isEqualTo(806)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day03(resourceAsString("day_3_input.txt")).solvePart2()).isEqualTo(363010)
    }
}