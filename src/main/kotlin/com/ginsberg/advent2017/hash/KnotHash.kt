/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017.hash

import com.ginsberg.advent2017.swap
import com.ginsberg.advent2017.toHex
import com.ginsberg.advent2017.xor

/**
 * Minimal implementation of a Knot Hash.
 * Mostly taken from Day 10 with all the Day 10 part 1 features pulled out.
 * Hard coded to have 64 iterations, and a ring of length 256.
 */
object KnotHash {

    private val magicLengths = listOf(17, 31, 73, 47, 23)

    fun hash(input: String): String =
        runForLengths(lengthsForString(input))
            .toList()
            .chunked(16)
            .joinToString("") { it.xor().toHex(2) }

    private fun runForLengths(lengths: IntArray): IntArray {
        val ring = IntArray(256) { it }
        var position = 0
        var skip = 0
        repeat(64) {
            lengths.forEach { length ->
                reverseSection(ring, position, length)
                position = (position + length + skip) % ring.size
                skip += 1
            }
        }
        return ring
    }

    private fun reverseSection(ring: IntArray, from: Int, length: Int) {
        var fromIdx = from % ring.size
        var toIdx = (fromIdx + length - 1) % ring.size
        repeat(length / 2) {
            ring.swap(fromIdx, toIdx)
            fromIdx = fromIdx.inc() % ring.size
            toIdx = toIdx.dec().takeIf { it >= 0 } ?: ring.size - 1
        }
    }

    private fun lengthsForString(input: String): IntArray =
        (input.map { it.toInt() } + magicLengths).toIntArray()
}
