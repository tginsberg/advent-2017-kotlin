/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ExtensionsKtTest {

    @Test
    fun `asDigit on Char handles 0-9 properly`() {
        assertThat("0123456789".map { it.asDigit() }.toList())
            .containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    @Test
    fun `asDigit on Char freaks out if you call it on a non-digit Char`() {
        assertThatThrownBy { 'A'.asDigit() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `isEven on Int handles numbers properly`() {
        assertThat(listOf(-2, 0, 2, 4, 6).map { it.isEven() }).containsOnly(true)
        assertThat(listOf(-1, 1, 3, 5, 7).map { it.isEven() }).containsOnly(false)
    }

    @Test
    fun `isOdd on Int handles numbers properly`() {
        assertThat(listOf(-2, 0, 2, 4, 6).map { it.isOdd() }).containsOnly(false)
        assertThat(listOf(-1, 1, 3, 5, 7).map { it.isOdd() }).containsOnly(true)
    }

    @Test
    fun `swapping valid indexes are swapped`() {
        assertThat(listOf(10, 20, 30).toIntArray().swap(0, 1))
            .containsExactly(20, 10, 30)
    }

    @Test
    fun `swapping left index under range freaks out`() {
        assertThatThrownBy { listOf(10, 20, 30).toIntArray().swap(-1, 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `swapping left index over range freaks out`() {
        assertThatThrownBy { listOf(10, 20, 30).toIntArray().swap(3, 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `swapping right index under range freaks out`() {
        assertThatThrownBy { listOf(10, 20, 30).toIntArray().swap(1, -1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `swapping right index over range freaks out`() {
        assertThatThrownBy { listOf(10, 20, 30).toIntArray().swap(1, -3) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `xor a list of integers`() {
        assertThat(listOf(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22).xor())
            .isEqualTo(64)
    }

    @Test
    fun `hex string is lower case`() {
        assertThat(15.toHex()).isEqualTo("f")
    }

    @Test
    fun `hex string with leading zeros`() {
        assertThat(15.toHex(2)).isEqualTo("0f")
    }
}