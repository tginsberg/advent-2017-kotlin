/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

// Char to numerical digit.
fun Char.asDigit(): Int = if(this.isDigit()) this-'0' else throw IllegalArgumentException()

// Even/Odd on Integer
fun Int.isEven(): Boolean = this % 2 == 0
fun Int.isOdd(): Boolean = this % 2 != 0
