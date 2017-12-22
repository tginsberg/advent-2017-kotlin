package com.ginsberg.advent2017.grid

import kotlin.math.sqrt

fun List<FractalGrid>.join(): FractalGrid {
    val rows = sqrt(this.size.toFloat()).toInt()
    return this.chunked(rows).map {
        it.reduce { a, b -> a nextTo b }
    }.reduce { a, b -> a over b }
}

data class FractalGrid(val grid: List<List<Char>>) {
    constructor(input: String) : this(
        input.split("/").map { it.toList() }
    )

    val size = grid.size

    infix fun nextTo(that: FractalGrid): FractalGrid =
        FractalGrid(
            grid.mapIndexed { idx, row -> row + that.grid[idx] }
        )

    infix fun over(that: FractalGrid): FractalGrid =
        FractalGrid(
            this.grid + that.grid
        )

    infix fun rowsOfSize(n: Int): List<FractalGrid> =
        this.grid.chunked(n).map { FractalGrid(it) }

    infix fun columnsOfSize(n: Int): List<FractalGrid> {
        val chunked = this.grid.map { row ->
            row.chunked(n)
        }
        return (0 until (grid[0].size) / n).map { x ->
            (0 until n).map { y ->
                chunked[y][x]
            }
        }.map { FractalGrid(it) }
    }

    fun split(): List<FractalGrid> {
        val splitSize = if (size % 2 == 0) 2 else 3
        val splits = size / splitSize
        if (splits == 1) {
            return listOf(this)
        }
        return (this rowsOfSize splitSize).map { it columnsOfSize splitSize }.flatten()
    }

    fun rotate(): FractalGrid =
        FractalGrid(
            (0 until grid.size).map { r ->
                (0 until grid.size).map { c ->
                    grid[c][(grid.size) - 1 - r]
                }
            }
        )

    fun flip(): FractalGrid =
        FractalGrid(grid.map { it.reversed() })

    fun combinations(): List<FractalGrid> {
        val rotations = (0 until 3).fold(listOf(this)) { rots, _ -> rots + rots.last().rotate() }
        val flips = rotations.map { it.flip() }
        return rotations + flips
    }

    override fun toString(): String =
        grid.joinToString("/") { it.joinToString("") }

}