package com.example.demo.dataDrivenTesting

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ForAllTest : StringSpec({
    "string length test" {
        forAll(
            row("hello", 5),
            row("kotest", 6),
            row("hello kotest!", 13),
            row("", 0),
        ) { str, expected ->
            str.length shouldBe expected
        }
    }
})