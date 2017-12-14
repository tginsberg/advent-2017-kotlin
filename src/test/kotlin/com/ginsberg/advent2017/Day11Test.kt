package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day11Test {

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day11("ne,ne,ne").solvePart1()).isEqualTo(3)
        assertThat(Day11("ne,ne,sw,sw").solvePart1()).isEqualTo(0)
        assertThat(Day11("ne,ne,s,s").solvePart1()).isEqualTo(2)
        assertThat(Day11("se,sw,se,sw,sw").solvePart1()).isEqualTo(3)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day11(resourceAsString("day_11_input.txt")).solvePart1())
            .isEqualTo(834)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day11("ne,ne,ne").solvePart2()).isEqualTo(3)
        assertThat(Day11("ne,ne,sw,sw").solvePart2()).isEqualTo(2)
        assertThat(Day11("ne,ne,s,s").solvePart2()).isEqualTo(2)
        assertThat(Day11("se,sw,se,sw,sw").solvePart2()).isEqualTo(3)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day11(resourceAsString("day_11_input.txt")).solvePart2())
            .isEqualTo(1569)
    }
}