package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day19Test {

    private val sampleInput = listOf(
        "     |           ",
        "     |  +--+     ",
        "     A  |  C     ",
        " F---|----E|--+  ",
        "     |  |  |  D  ",
        "     +B-+  +--+  ",
        "                 "
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day19(sampleInput).solvePart1()).isEqualTo("ABCDEF")
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day19(resourceAsList("day_19_input.txt")).solvePart1())
            .isEqualTo("DTOUFARJQ")
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day19(sampleInput).solvePart2()).isEqualTo(38)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day19(resourceAsList("day_19_input.txt")).solvePart2())
            .isEqualTo(16642)
    }

}