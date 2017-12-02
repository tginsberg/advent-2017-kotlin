/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ExtensionsKtTest {

    @Test
    fun `asDigit handles 0-9 properly`() {
        assertThat("0123456789".map { it.asDigit() }.toList())
            .containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    @Test
    fun `asDigit freaks out if you call it on a non-digit Char`() {
        assertThatThrownBy { 'A'.asDigit() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}