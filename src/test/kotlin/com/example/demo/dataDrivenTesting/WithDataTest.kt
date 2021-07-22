package com.example.demo.dataDrivenTesting

import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

@ExperimentalKotest
internal class WithDataTest : FunSpec({
    context("string length test") {
        withData(
            StringLengthTuple("hello", 5),
            StringLengthTuple("kotest", 6),
            StringLengthTuple("hello kotest!", 13),
            StringLengthTuple("", 0),
        ) { (str, expected) ->
            str.length shouldBe expected
        }
    }
})

data class StringLengthTuple(
    val str: String,
    val expected: Int,
)