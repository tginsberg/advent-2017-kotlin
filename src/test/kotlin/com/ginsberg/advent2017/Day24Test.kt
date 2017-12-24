package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day24Test {

    val sampleInput = listOf(
        "0/2",
        "2/2",
        "2/3",
        "3/4",
        "3/5",
        "0/1",
        "10/1",
        "9/10"
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day24(sampleInput).solvePart1()).isEqualTo(31)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day24(resourceAsList("day_24_input.txt")).solvePart1())
            .isEqualTo(1940)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day24(sampleInput).solvePart2()).isEqualTo(19)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day24(resourceAsList("day_24_input.txt")).solvePart2())
            .isEqualTo(1928)
    }

}