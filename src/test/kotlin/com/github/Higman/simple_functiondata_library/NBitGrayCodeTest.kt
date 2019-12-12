package com.github.Higman.simple_functiondata_library

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NBitGrayCodeTest {
    @Test
    fun デコーディングテスト() {
        Assertions.assertEquals(6, NBitGrayCode(listOf(1, 0, 1, 0)).toInt())
        Assertions.assertEquals(4, NBitGrayCode(listOf(0, 1, 1, 0)).toInt())
        Assertions.assertEquals(12,NBitGrayCode(listOf(0, 1, 0, 1)).toInt())
    }
}