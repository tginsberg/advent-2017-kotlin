package com.ginsberg.advent2017.grid

import kotlin.math.sqrt

fun List<SquareGrid>.join(): SquareGrid {
    val rows = sqrt(this.size.toFloat()).toInt()
    return this.chunked(rows).map {
        it.reduce { a, b -> a nextTo b }
    }.reduce { a, b -> a over b }
}

data class SquareGrid(val grid: List<List<Char>>) {
    constructor(input: String) : this(
        input.split("/").map { it.toList() }
    )

    val size = grid.size

    infix fun nextTo(that: SquareGrid): SquareGrid =
        SquareGrid(
            grid.mapIndexed { idx, row -> row + that.grid[idx] }
        )

    infix fun over(that: SquareGrid): SquareGrid =
        SquareGrid(
            this.grid + that.grid
        )

    infix fun rowsOfSize(n: Int): List<SquareGrid> =
        this.grid.chunked(n).map { SquareGrid(it) }

    infix fun columnsOfSize(n: Int): List<SquareGrid> {
        val chunked = this.grid.map { row ->
            row.chunked(n)
        }
        return (0 until (grid[0].size) / n).map { x ->
            (0 until n).map { y ->
                chunked[y][x]
            }
        }.map { SquareGrid(it) }
    }

    fun split(): List<SquareGrid> {
        val splitSize = if (size % 2 == 0) 2 else 3
        val splits = size / splitSize
        if (splits == 1) {
            return listOf(this)
        }
        return (this rowsOfSize splitSize).map { it columnsOfSize splitSize }.flatten()
    }

    fun rotate(): SquareGrid =
        SquareGrid(
            (0 until grid.size).map { r ->
                (0 until grid.size).map { c ->
                    grid[c][(grid.size) - 1 - r]
                }
            }
        )

    fun flip(): SquareGrid =
        SquareGrid(grid.map { it.reversed() })

    fun combinations(): List<SquareGrid> {
        val rotations = (0 until 3).fold(listOf(this)) { rots, _ -> rots + rots.last().rotate() }
        val flips = rotations.map { it.flip() }
        return rotations + flips
    }

    override fun toString(): String =
        grid.joinToString("/") { it.joinToString("") }

}