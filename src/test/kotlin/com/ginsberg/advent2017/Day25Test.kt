package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day25Test {

    val sampleInput = listOf(
        "Begin in state A.",
        "Perform a diagnostic checksum after 6 steps.",
        "",
        "   In state A:",
        "     If the current value is 0:",
        "       - Write the value 1.",
        "       - Move one slot to the right.",
        "       - Continue with state B.",
        "     If the current value is 1:",
        "       - Write the value 0.",
        "       - Move one slot to the left.",
        "       - Continue with state B.",
        "",
        "   In state B:",
        "     If the current value is 0:",
        "       - Write the value 1.",
        "       - Move one slot to the left.",
        "       - Continue with state A.",
        "     If the current value is 1:",
        "       - Write the value 1.",
        "       - Move one slot to the right.",
        "       - Continue with state A."
        )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day25(sampleInput).solvePart1()).isEqualTo(3)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day25(resourceAsList("day_25_input.txt")).solvePart1()).isEqualTo(633)
    }

}