package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day20Test {


    @Test
    fun `Part 1 matches example`() {
        val sampleInput = listOf(
            "p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>",
            "p=<4,0,0>, v=< 0,0,0>, a=<-2,0,0>"
        )
        assertThat(Day20(sampleInput).solvePart1()).isEqualTo(0)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day20(resourceAsList("day_20_input.txt")).solvePart1())
            .isEqualTo(119)
    }

    @Test
    fun `Part 2 matches example`() {
        val sampleInput = listOf(
            "p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>",
            "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>",
            "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>",
            "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>"
        )
        assertThat(Day20(sampleInput).solvePart2()).isEqualTo(1)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day20(resourceAsList("day_20_input.txt")).solvePart2())
            .isEqualTo(471)
    }

}