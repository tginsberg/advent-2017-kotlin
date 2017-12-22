package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day22Test {

    val sampleInput = listOf(
        "..#",
        "#..",
        "..."
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day22(sampleInput).solvePart1(0)).isEqualTo(0)
        assertThat(Day22(sampleInput).solvePart1(7)).isEqualTo(5)
        assertThat(Day22(sampleInput).solvePart1(70)).isEqualTo(41)
        assertThat(Day22(sampleInput).solvePart1(10000)).isEqualTo(5587)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day22(resourceAsList("day_22_input.txt")).solvePart1())
            .isEqualTo(5462)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day22(sampleInput).solvePart2(100)).isEqualTo(26)
        assertThat(Day22(sampleInput).solvePart2(10_000_000)).isEqualTo(2_511_944)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day22(resourceAsList("day_22_input.txt")).solvePart2())
            .isEqualTo(2512135)
    }

}