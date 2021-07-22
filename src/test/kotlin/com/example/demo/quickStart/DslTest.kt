package com.example.demo.quickStart

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class DslTest : FunSpec({
    test("this is first test") {
        val name = "hello kotest!"
        val actual = name.length
        actual shouldBe 13
    }
})