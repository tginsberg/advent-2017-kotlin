package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day02Test {


    @Test()
    fun `Part 1 matches example`() {
        val part1ExampleInput = listOf("5 1 9 5", "7 5 3", "2 4 6 8")
        assertThat(Day02(part1ExampleInput).solvePart1())
            .isEqualTo(18)
    }

    @Test()
    fun `Part 1 actual answer`() {
        assertThat(Day02(resourceAsList("day_2_input.txt")).solvePart1())
            .isEqualTo(21845)
    }


    @Test()
    fun `Part 2 matches example`() {
        val part2ExampleInput = listOf("5 9 2 8" , "9 4 7 3", "3 8 6 5")
        assertThat(Day02(part2ExampleInput).solvePart2())
            .isEqualTo(9)
    }

    @Test()
    fun `Part 2 actual answer`() {
        assertThat(Day02(resourceAsList("day_2_input.txt")).solvePart2())
            .isEqualTo(191)
    }
}