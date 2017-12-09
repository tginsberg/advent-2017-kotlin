package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day09Test {

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day09("{}").solvePart1()).isEqualTo(1)
        assertThat(Day09("{{{}}}").solvePart1()).isEqualTo(6)
        assertThat(Day09("{{},{}}").solvePart1()).isEqualTo(5)
        assertThat(Day09("{<a>,<a>,<a>,<a>}").solvePart1()).isEqualTo(1)
        assertThat(Day09("{{<ab>},{<ab>},{<ab>},{<ab>}}").solvePart1()).isEqualTo(9)
        assertThat(Day09("{{<!!>},{<!!>},{<!!>},{<!!>}}").solvePart1()).isEqualTo(9)
        assertThat(Day09("{{<a!>},{<a!>},{<a!>},{<ab>}}").solvePart1()).isEqualTo(3)
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day09(resourceAsString("day_9_input.txt")).solvePart1()).isEqualTo(14204)
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day09("<>").solvePart2()).isEqualTo(0)
        assertThat(Day09("<random characters>").solvePart2()).isEqualTo(17)
        assertThat(Day09("<<<<>").solvePart2()).isEqualTo(3)
        assertThat(Day09("<{!>}>").solvePart2()).isEqualTo(2)
        assertThat(Day09("<!!>").solvePart2()).isEqualTo(0)
        assertThat(Day09("<!!!>>").solvePart2()).isEqualTo(0)
        assertThat(Day09("""<{o"i!a,<{i<a>""").solvePart2()).isEqualTo(10)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day09(resourceAsString("day_9_input.txt")).solvePart2()).isEqualTo(6622)
    }
}