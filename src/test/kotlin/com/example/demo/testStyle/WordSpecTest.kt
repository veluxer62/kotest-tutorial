package com.example.demo.testStyle

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class WordSpecTest : WordSpec({
    "String.length" should {
        val name = "hello kotest!"
        val actual = name.length
        "return length of string" {
            actual shouldBe 13
        }
    }

    "number string" `when` {
        val number = "12345"
        "parsed integer" should {
            val actual = number.toInt()
            "return integer value" {
                actual shouldBe 12345
            }
        }

        "parsed long" should {
            val actual = number.toLong()
            "return long value" {
                actual shouldBe 12345L
            }
        }
    }
})
