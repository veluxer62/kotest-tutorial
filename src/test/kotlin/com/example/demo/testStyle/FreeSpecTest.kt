package com.example.demo.testStyle

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

internal class FreeSpecTest : FreeSpec({
    "String.length" - {
        val name = "hello kotest!"
        val actual = name.length
        "should return length of string" {
            actual shouldBe 13
        }
    }

    "number string" - {
        val number = "12345"
        "when parsed integer" - {
            val actual = number.toInt()
            "should return integer value" {
                actual shouldBe 12345
            }
        }

        "when parsed long" - {
            val actual = number.toLong()
            "should return long value" {
                actual shouldBe 12345L
            }
        }
    }

    var str: String
    var actual: LocalDateTime

    "given str is datetime string" - {
        str = "2011-12-03T10:15:30"
        "when parse LocalDateTime form string" - {
            actual = LocalDateTime.parse(str)
            "then actual should be LocalDateTime object" {
                actual shouldBe LocalDateTime.of(2011, 12, 3, 10, 15, 30)
            }
        }
    }
})
