package com.example.demo.testStyle

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class FunSpecTest : FunSpec({
    test("String.length should return the length of the string") {
        val name = "hello kotest!"
        val actual = name.length
        actual shouldBe 13
    }

    context("toInt") {
        test("given number string should return integer value") {
            val number = "12345"
            val actual = number.toInt()
            actual shouldBe 12345
        }

        test("given not number string should return exception") {
            val str = "not a number"
            shouldThrow<NumberFormatException> {
                str.toInt()
            }
        }
    }
})
