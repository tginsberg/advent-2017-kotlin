package com.ginsberg.advent2017.grid

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SquareGridTest {

    private val sampleSquare = SquareGrid("123/456/789")

    @Test
    fun `flip does the flippy thing`() {
        assertThat(sampleSquare.flip()).isEqualTo(SquareGrid("321/654/987"))
    }

    @Test
    fun `rotate works anticlockwise`() {
        assertThat(sampleSquare.rotate()).isEqualTo(SquareGrid("369/258/147"))
    }

    @Test
    fun `combinations returns eight flipped and rotated grids`() {
        val response = sampleSquare.combinations()
        assertThat(response)
            .hasSize(8)
            .containsExactlyInAnyOrder(
                SquareGrid("123/456/789"),
                SquareGrid("369/258/147"),
                SquareGrid("987/654/321"),
                SquareGrid("741/852/963"),
                SquareGrid("321/654/987"),
                SquareGrid("963/852/741"),
                SquareGrid("789/456/123"),
                SquareGrid("147/258/369")
            )
    }

    @Test
    fun `splitting 4x4 yields 4 2x2 grids`() {
        assertThat(SquareGrid("1234/5678/9ABC/DEFG").split())
            .hasSize(4)
            .containsExactlyInAnyOrder(
                SquareGrid("12/56"),
                SquareGrid("34/78"),
                SquareGrid("9A/DE"),
                SquareGrid("BC/FG")
            )
    }

    @Test
    fun `splitting 9x9 yields 9 3x3 grids`() {
        assertThat(SquareGrid("AAABBBCCC/AAABBBCCC/AAABBBCCC/DDDEEEFFF/DDDEEEFFF/DDDEEEFFF/GGGHHHIII/GGGHHHIII/GGGHHHIII").split())
            .hasSize(9)
            .containsExactlyInAnyOrder(
                SquareGrid("AAA/AAA/AAA"),
                SquareGrid("BBB/BBB/BBB"),
                SquareGrid("CCC/CCC/CCC"),
                SquareGrid("DDD/DDD/DDD"),
                SquareGrid("EEE/EEE/EEE"),
                SquareGrid("FFF/FFF/FFF"),
                SquareGrid("GGG/GGG/GGG"),
                SquareGrid("HHH/HHH/HHH"),
                SquareGrid("III/III/III")
            )
    }

    @Test
    fun `side by side grids`() {
        assertThat(SquareGrid("12/56") nextTo SquareGrid("34/78"))
            .isEqualTo(SquareGrid("1234/5678"))
    }

    @Test
    fun `on top of grids`() {
        assertThat(SquareGrid("12/56") over SquareGrid("34/78"))
            .isEqualTo(SquareGrid("12/56/34/78"))
    }

    @Test
    fun `split by rows`() {
        assertThat(SquareGrid("1234/5678/9ABC/DEFG") rowsOfSize 2)
            .hasSize(2)
            .containsExactlyInAnyOrder(
                SquareGrid("1234/5678"),
                SquareGrid("9ABC/DEFG")
            )
    }

    @Test
    fun `split by column`() {
        assertThat(SquareGrid("1234/5678/9ABC/DEFG") columnsOfSize 2)
            .hasSize(2)
            .containsExactlyInAnyOrder(
                SquareGrid("12/56/9A/DE"),
                SquareGrid("34/78/BC/FG")
            )
    }

    @Test
    fun `split by 2`() {
        assertThat(SquareGrid("1234/5678/9ABC/DEFG").split())
            .hasSize(4)
            .containsExactly(
                SquareGrid("12/56"),
                SquareGrid("34/78"),
                SquareGrid("9A/DE"),
                SquareGrid("BC/FG")
            )
    }

    @Test
    fun `split by 3`() {
        assertThat(SquareGrid("111111/222222/333333/444444/555555/666666").split())
            .hasSize(9)
            .containsExactly(
                SquareGrid("11/22"),
                SquareGrid("11/22"),
                SquareGrid("11/22"),
                SquareGrid("33/44"),
                SquareGrid("33/44"),
                SquareGrid("33/44"),
                SquareGrid("55/66"),
                SquareGrid("55/66"),
                SquareGrid("55/66")
            )
    }

    @Test
    fun `joining 4 2x2 grids yields 1 4x4 grid`() {
        assertThat(
            listOf(
                SquareGrid("12/56"),
                SquareGrid("34/78"),
                SquareGrid("9A/DE"),
                SquareGrid("BC/FG")
            ).join()
        ).isEqualTo(SquareGrid("1234/5678/9ABC/DEFG"))
    }


    @Test
    fun `joining 4 3x3 grids yields 1 6x6 grid`() {
        assertThat(
            listOf(
                SquareGrid("123/123/123"),
                SquareGrid("456/456/456"),
                SquareGrid("ABC/ABC/ABC"),
                SquareGrid("DEF/DEF/DEF")
            ).join()
        ).isEqualTo(SquareGrid("123456/123456/123456/ABCDEF/ABCDEF/ABCDEF"))
    }
}