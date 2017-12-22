package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day21Test {

    private val sampleInput = listOf(
        "../.# => ##./#../...",
        ".#./..#/### => #..#/..../..../#..#"
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day21(sampleInput).solve(2)).isEqualTo(12)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day21(resourceAsList("day_21_input.txt")).solve(5))
            .isEqualTo(194)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day21(resourceAsList("day_21_input.txt")).solve(18))
            .isEqualTo(2536879)
    }


}