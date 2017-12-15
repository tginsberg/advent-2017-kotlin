package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day15Text {

    private val sampleInput = listOf(
        "Generator A starts with 65",
        "Generator B starts with 8921"
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day15(sampleInput).solvePart1(5)).isEqualTo(1)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day15(resourceAsList("day_15_input.txt")).solvePart1())
            .isEqualTo(573)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day15(sampleInput).solvePart2()).isEqualTo(309)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day15(resourceAsList("day_15_input.txt")).solvePart2())
            .isEqualTo(294)
    }

}