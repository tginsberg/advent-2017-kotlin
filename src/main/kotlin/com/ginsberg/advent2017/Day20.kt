/*
 * Copyright (c) 2017 by Todd Ginsberg
 */

package com.ginsberg.advent2017

import kotlin.math.absoluteValue

/**
 * AoC 2017, Day 20
 *
 * Problem Description: http://adventofcode.com/2017/day/20
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2017/day20/
 */
class Day20(input: List<String>) {

    private val particles: List<Particle> = input.mapIndexed { idx, s -> parseParticle(idx, s) }

    fun solvePart1(): Int =
        (1..1000).fold(particles) { acc, _ ->
            acc.map { it.move() }
        }.minBy { it.position.distance }?.id ?: throw IllegalArgumentException("Wat")

    fun solvePart2(): Int =
        (1..1000).fold(particles) { acc, _ ->
            acc.map { it.move() }
                .groupBy { it.position }
                .filterValues { it.size == 1 }
                .flatMap { it.value }
        }.size

    private fun parseParticle(id: Int, input: String): Particle =
        input.split("<", ">").let {
            Particle(
                id = id,
                position = parseVec(it[1]),
                velocity = parseVec(it[3]),
                acceleration = parseVec(it[5])
            )
        }

    private fun parseVec(input: String): Vec3D =
        input.split(",").map { it.trim().toLong() }.let {
            Vec3D(it[0], it[1], it[2])
        }

    data class Vec3D(val x: Long, val y: Long, val z: Long) {

        val distance: Long =
            x.absoluteValue + y.absoluteValue + z.absoluteValue

        operator fun plus(that: Vec3D): Vec3D =
            Vec3D(x = x + that.x, y = y + that.y, z = z + that.z)

    }

    data class Particle(val id: Int,
                        val position: Vec3D,
                        val velocity: Vec3D,
                        var acceleration: Vec3D) {

        fun move() =
            this.copy(
                velocity = velocity + acceleration,
                position = position + velocity + acceleration
            )
    }
}
