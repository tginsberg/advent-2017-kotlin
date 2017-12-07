package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day07Test {

    private val sampleInput = listOf(
        "pbga (66)",
        "xhth (57)",
        "ebii (61)",
        "havc (66)",
        "ktlj (57)",
        "fwft (72) -> ktlj, cntj, xhth",
        "qoyq (66)",
        "padx (45) -> pbga, havc, qoyq",
        "tknk (41) -> ugml, padx, fwft",
        "jptl (61)",
        "ugml (68) -> gyxo, ebii, jptl",
        "gyxo (61)",
        "cntj (57)"
    )

    @Test
    fun `Part 1 matches example`() {
        assertThat(Day07(sampleInput).solvePart1()).isEqualTo("tknk")
    }

    @Test
    fun `Part 1 actual answer`() {
        assertThat(Day07(resourceAsList("day_7_input.txt")).solvePart1()).isEqualTo("vtzay")
    }

    @Test
    fun `Part 2 matches example`() {
        assertThat(Day07(sampleInput).solvePart2()).isEqualTo(60)
    }

    @Test
    fun `Part 2 actual answer`() {
        assertThat(Day07(resourceAsList("day_7_input.txt")).solvePart2()).isEqualTo(910)
    }
}