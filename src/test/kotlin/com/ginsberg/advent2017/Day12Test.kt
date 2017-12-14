package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day12Test {

    private val sampleInput = listOf(
        "0 <-> 2",
        "1 <-> 1",
        "2 <-> 0, 3, 4",
        "3 <-> 2, 4",
        "4 <-> 2, 3, 6",
        "5 <-> 6",
        "6 <-> 4, 5"
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day12(sampleInput).solvePart1()).isEqualTo(6)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day12(resourceAsList("day_12_input.txt")).solvePart1())
            .isEqualTo(115)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day12(sampleInput).solvePart2()).isEqualTo(2)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day12(resourceAsList("day_12_input.txt")).solvePart2())
            .isEqualTo(221)
    }
}