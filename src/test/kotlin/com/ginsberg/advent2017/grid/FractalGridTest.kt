package com.ginsberg.advent2017.grid

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FractalGridTest {

    private val sampleSquare = FractalGrid("123/456/789")

    @Test
    fun `flip does the flippy thing`() {
        assertThat(sampleSquare.flip()).isEqualTo(FractalGrid("321/654/987"))
    }

    @Test
    fun `rotate works anticlockwise`() {
        assertThat(sampleSquare.rotate()).isEqualTo(FractalGrid("369/258/147"))
    }

    @Test
    fun `combinations returns eight flipped and rotated grids`() {
        val response = sampleSquare.combinations()
        assertThat(response)
            .hasSize(8)
            .containsExactlyInAnyOrder(
                FractalGrid("123/456/789"),
                FractalGrid("369/258/147"),
                FractalGrid("987/654/321"),
                FractalGrid("741/852/963"),
                FractalGrid("321/654/987"),
                FractalGrid("963/852/741"),
                FractalGrid("789/456/123"),
                FractalGrid("147/258/369")
            )
    }

    @Test
    fun `splitting 4x4 yields 4 2x2 grids`() {
        assertThat(FractalGrid("1234/5678/9ABC/DEFG").split())
            .hasSize(4)
            .containsExactlyInAnyOrder(
                FractalGrid("12/56"),
                FractalGrid("34/78"),
                FractalGrid("9A/DE"),
                FractalGrid("BC/FG")
            )
    }

    @Test
    fun `splitting 9x9 yields 9 3x3 grids`() {
        assertThat(FractalGrid("AAABBBCCC/AAABBBCCC/AAABBBCCC/DDDEEEFFF/DDDEEEFFF/DDDEEEFFF/GGGHHHIII/GGGHHHIII/GGGHHHIII").split())
            .hasSize(9)
            .containsExactlyInAnyOrder(
                FractalGrid("AAA/AAA/AAA"),
                FractalGrid("BBB/BBB/BBB"),
                FractalGrid("CCC/CCC/CCC"),
                FractalGrid("DDD/DDD/DDD"),
                FractalGrid("EEE/EEE/EEE"),
                FractalGrid("FFF/FFF/FFF"),
                FractalGrid("GGG/GGG/GGG"),
                FractalGrid("HHH/HHH/HHH"),
                FractalGrid("III/III/III")
            )
    }

    @Test
    fun `side by side grids`() {
        assertThat(FractalGrid("12/56") nextTo FractalGrid("34/78"))
            .isEqualTo(FractalGrid("1234/5678"))
    }

    @Test
    fun `on top of grids`() {
        assertThat(FractalGrid("12/56") over FractalGrid("34/78"))
            .isEqualTo(FractalGrid("12/56/34/78"))
    }

    @Test
    fun `split by rows`() {
        assertThat(FractalGrid("1234/5678/9ABC/DEFG") rowsOfSize 2)
            .hasSize(2)
            .containsExactlyInAnyOrder(
                FractalGrid("1234/5678"),
                FractalGrid("9ABC/DEFG")
            )
    }

    @Test
    fun `split by column`() {
        assertThat(FractalGrid("1234/5678") columnsOfSize 2)
            .hasSize(2)
            .containsExactlyInAnyOrder(
                FractalGrid("12/56"),
                FractalGrid("34/78")
            )
    }

    @Test
    fun `split by 2`() {
        assertThat(FractalGrid("1234/5678/9ABC/DEFG").split())
            .hasSize(4)
            .containsExactly(
                FractalGrid("12/56"),
                FractalGrid("34/78"),
                FractalGrid("9A/DE"),
                FractalGrid("BC/FG")
            )
    }

    @Test
    fun `split by 3`() {
        assertThat(FractalGrid("111111/222222/333333/444444/555555/666666").split())
            .hasSize(9)
            .containsExactly(
                FractalGrid("11/22"),
                FractalGrid("11/22"),
                FractalGrid("11/22"),
                FractalGrid("33/44"),
                FractalGrid("33/44"),
                FractalGrid("33/44"),
                FractalGrid("55/66"),
                FractalGrid("55/66"),
                FractalGrid("55/66")
            )
    }

    @Test
    fun `joining 4 2x2 grids yields 1 4x4 grid`() {
        assertThat(
            listOf(
                FractalGrid("12/56"),
                FractalGrid("34/78"),
                FractalGrid("9A/DE"),
                FractalGrid("BC/FG")
            ).join()
        ).isEqualTo(FractalGrid("1234/5678/9ABC/DEFG"))
    }


    @Test
    fun `joining 4 3x3 grids yields 1 6x6 grid`() {
        assertThat(
            listOf(
                FractalGrid("123/123/123"),
                FractalGrid("456/456/456"),
                FractalGrid("ABC/ABC/ABC"),
                FractalGrid("DEF/DEF/DEF")
            ).join()
        ).isEqualTo(FractalGrid("123456/123456/123456/ABCDEF/ABCDEF/ABCDEF"))
    }
}