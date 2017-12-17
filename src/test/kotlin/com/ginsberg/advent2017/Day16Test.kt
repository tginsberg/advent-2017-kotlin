package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day16Test {

    private val sampleInput = "s1, x3/4, pe/b"

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day16(sampleInput, "abcde").solvePart1()).isEqualTo("baedc")
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day16(resourceAsString("day_16_input.txt")).solvePart1())
            .isEqualTo("ehdpincaogkblmfj")
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day16(resourceAsString("day_16_input.txt")).solvePart2())
            .isEqualTo("bpcekomfgjdlinha")
    }

}