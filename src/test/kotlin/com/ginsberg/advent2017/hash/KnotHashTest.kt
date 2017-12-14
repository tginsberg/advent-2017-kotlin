package com.ginsberg.advent2017.hash

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KnotHashTest {

    @Test
    fun `hashes known strings properly`() {
        assertThat(KnotHash.hash("")).isEqualTo("a2582a3a0e66e6e86e3812dcb672a272")
        assertThat(KnotHash.hash("AoC 2017")).isEqualTo("33efeb34ea91902bb2f59c9920caa6cd")
        assertThat(KnotHash.hash("1,2,3")).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d")
        assertThat(KnotHash.hash("1,2,4")).isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e")
    }
}