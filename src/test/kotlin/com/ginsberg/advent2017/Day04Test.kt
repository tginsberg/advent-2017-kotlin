package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day04Test {


    @Test
    fun `Part 1 matches example`() {
        val sample = listOf("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa")
        assertThat(Day04(sample).solvePart1()).isEqualTo(2)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day04(resourceAsList("day_4_input.txt")).solvePart1()).isEqualTo(325)
    }

    @Test
    fun `Part 2 matches example`() {
        val sample = listOf(
            "abcde fghij", "abcde xyz ecdab", "a ab abc abd abf abj",
            "iiii oiii ooii oooi oooo", "oiii ioii iioi iiio")
        assertThat(Day04(sample).solvePart2()).isEqualTo(3)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day04(resourceAsList("day_4_input.txt")).solvePart2()).isEqualTo(119)
    }
}