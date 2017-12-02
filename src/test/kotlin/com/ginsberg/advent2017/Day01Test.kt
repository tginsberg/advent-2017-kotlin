/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day01Test {

    @Test()
    fun `Part 1 matches example`() {
        assertThat(Day01("1122").solvePart1()).isEqualTo(3)
        assertThat(Day01("1111").solvePart1()).isEqualTo(4)
        assertThat(Day01("1234").solvePart1()).isEqualTo(0)
        assertThat(Day01("91212129").solvePart1()).isEqualTo(9)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day01(resourceAsString("day_1_input.txt")).solvePart1())
            .isEqualTo(1031)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day01("1212").solvePart2()).isEqualTo(6)
        assertThat(Day01("1221").solvePart2()).isEqualTo(0)
        assertThat(Day01("123425").solvePart2()).isEqualTo(4)
        assertThat(Day01("123123").solvePart2()).isEqualTo(12)
        assertThat(Day01("12131415").solvePart2()).isEqualTo(4)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day01(resourceAsString("day_1_input.txt")).solvePart2())
            .isEqualTo(1080)
    }
}