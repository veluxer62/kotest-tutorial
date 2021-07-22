package com.example.demo.testStyle

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

internal class ExpectSpecTest : ExpectSpec({
    expect("String.length should return the length of the string") {
        val name = "hello kotest!"
        val actual = name.length
        actual shouldBe 13
    }

    context("toInt") {
        expect("given number string should return integer value") {
            val number = "12345"
            val actual = number.toInt()
            actual shouldBe 12345
        }

        expect("given not number string should return exception") {
            val str = "not a number"
            shouldThrow<NumberFormatException> {
                str.toInt()
            }
        }
    }
})
