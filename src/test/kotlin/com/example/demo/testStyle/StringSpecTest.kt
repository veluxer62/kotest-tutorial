package com.example.demo.testStyle

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class StringSpecTest : StringSpec({
    "String.length should return the length of the string" {
        val name = "hello kotest!"
        val actual = name.length
        actual shouldBe 13
    }
})
