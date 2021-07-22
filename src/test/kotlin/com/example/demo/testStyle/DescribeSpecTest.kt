package com.example.demo.testStyle

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class DescribeSpecTest : DescribeSpec({
    describe("toInt") {
        it("given number string should return integer value") {
            val number = "12345"
            val actual = number.toInt()
            actual shouldBe 12345
        }

        it("given not number string should return exception") {
            val str = "not a number"
            shouldThrow<NumberFormatException> {
                str.toInt()
            }
        }
    }
})
