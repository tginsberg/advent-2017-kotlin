package com.ginsberg.advent2017.grid

import kotlin.math.absoluteValue

/**
 * Represents a Spot on a Hexagonal map.
 * For reasoning, etc, go here: https://www.redblobgames.com/grids/hexagons/#distances-cube
 */
class HexSpot(private val x: Int, private val y: Int, private val z: Int) {

    fun travel(direction: String): HexSpot =
        when (direction) {
            "n" -> HexSpot(x, y + 1, z - 1)
            "s" -> HexSpot(x, y - 1, z + 1)
            "ne" -> HexSpot(x + 1, y, z - 1)
            "nw" -> HexSpot(x - 1, y + 1, z)
            "se" -> HexSpot(x + 1, y - 1, z)
            "sw" -> HexSpot(x - 1, y, z + 1)
            else -> throw IllegalArgumentException("Invalid direction: $direction")
        }

    fun distanceTo(there: HexSpot): Int =
        maxOf(
            (this.x - there.x).absoluteValue,
            (this.y - there.y).absoluteValue,
            (this.z - there.z).absoluteValue
        )
}
