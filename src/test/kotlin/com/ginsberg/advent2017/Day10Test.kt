package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day10Test {

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day10("3,4,1,5", true, 5).solvePart1()).isEqualTo(12)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day10(resourceAsString("day_10_input.txt").trim(), true).solvePart1()).isEqualTo(19591)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day10("", false).solvePart2()).isEqualTo("a2582a3a0e66e6e86e3812dcb672a272")
        assertThat(Day10("AoC 2017", false).solvePart2()).isEqualTo("33efeb34ea91902bb2f59c9920caa6cd")
        assertThat(Day10("1,2,3", false).solvePart2()).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d")
        assertThat(Day10("1,2,4", false).solvePart2()).isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e")
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day10(resourceAsString("day_10_input.txt").trim(), false).solvePart2())
            .isEqualTo("62e2204d2ca4f4924f6e7a80f1288786")
    }
}