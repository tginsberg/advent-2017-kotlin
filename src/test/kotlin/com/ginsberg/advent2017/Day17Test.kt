package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day17Test {

    private val sampleInput = "3"

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day17(sampleInput).solvePart1()).isEqualTo(638)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day17(resourceAsString("day_17_input.txt")).solvePart1())
            .isEqualTo(1971)
    }


    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day17(resourceAsString("day_17_input.txt")).solvePart2())
            .isEqualTo(17202899)
    }

}