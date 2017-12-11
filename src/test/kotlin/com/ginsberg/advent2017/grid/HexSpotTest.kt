package com.ginsberg.advent2017.grid

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class HexSpotTest {

    private val origin = HexSpot(0, 0, 0)

    @Test
    fun `handles known directions without failing`() {
        assertThat(origin.travel("n")).isNotNull()
        assertThat(origin.travel("s")).isNotNull()
        assertThat(origin.travel("ne")).isNotNull()
        assertThat(origin.travel("nw")).isNotNull()
        assertThat(origin.travel("se")).isNotNull()
        assertThat(origin.travel("sw")).isNotNull()
    }

    @Test
    fun `freaks out if asked to travel in an unknown direction`() {
        assertThatThrownBy { origin.travel("e") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `calculates direct north direction`() {
        val endpoint = listOf("n", "n").fold(origin) { spot, dir -> spot.travel(dir) }
        assertThat(origin.distanceTo(endpoint)).isEqualTo(2)
    }

    @Test
    fun `calculates direct south direction`() {
        val endpoint = listOf("s", "s").fold(origin) { spot, dir -> spot.travel(dir) }
        assertThat(origin.distanceTo(endpoint)).isEqualTo(2)
    }

    @Test
    fun `calculates direct northeast direction`() {
        val endpoint = listOf("ne", "ne").fold(origin) { spot, dir -> spot.travel(dir) }
        assertThat(origin.distanceTo(endpoint)).isEqualTo(2)
    }

    @Test
    fun `calculates direct northwest direction`() {
        val endpoint = listOf("nw", "nw").fold(origin) { spot, dir -> spot.travel(dir) }
        assertThat(origin.distanceTo(endpoint)).isEqualTo(2)
    }

    @Test
    fun `calculates direct southeast direction`() {
        val endpoint = listOf("se", "se").fold(origin) { spot, dir -> spot.travel(dir) }
        assertThat(origin.distanceTo(endpoint)).isEqualTo(2)
    }

    @Test
    fun `calculates direct southwest direction`() {
        val endpoint = listOf("sw", "sw").fold(origin) { spot, dir -> spot.travel(dir) }
        assertThat(origin.distanceTo(endpoint)).isEqualTo(2)
    }
}