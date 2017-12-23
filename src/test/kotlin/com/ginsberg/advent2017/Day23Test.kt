package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day23Test {

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day23(resourceAsList("day_23_input.txt")).solvePart1())
            .isEqualTo(4225)
    }


    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day23(resourceAsList("day_23_input.txt")).solvePart2())
            .isEqualTo(905)
    }

}