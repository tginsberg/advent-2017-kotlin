/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

// Char to numerical digit.
fun Char.asDigit(): Int = if (this.isDigit()) this - '0' else throw IllegalArgumentException()

// Even/Odd on Integer
fun Int.isEven(): Boolean = this % 2 == 0

fun Int.isOdd(): Boolean = this % 2 != 0

// In-place swap elements on an IntArray
fun IntArray.swap(a: Int, b: Int): IntArray {
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
    return this
}

// In-place swap elements on a CharArray
fun CharArray.swap(a: Int, b: Int): CharArray {
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
    return this
}

// Xor a List of Ints
fun List<Int>.xor(): Int = this.reduce { a, b -> a xor b }

// Int to HEX String with leading zeros...
fun Int.toHex(width: Int = 1): String = "%0${width}x".format(this)

// Find the value in the Map, or convert it to a Long and return it.
fun Map<String, Long>.deref(value: String): Long =
    this.getOrElse(value) {
        try {
            value.toLong()
        } catch (e: NumberFormatException) {
            0
        }
    }
