package com.example.demo.testStyle

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class BehaviorSpecTest : BehaviorSpec({
    var str: String
    var formatter: DateTimeFormatter
    var actual: LocalDateTime

    given("str is datetime string") {
        str = "2011-12-03T10:15:30"
        `when`("parse LocalDateTime form string") {
            actual = LocalDateTime.parse(str)
            then("actual should be LocalDateTime object") {
                actual shouldBe LocalDateTime.of(2011, 12, 3, 10, 15, 30)
            }
        }
    }

    given("str is custom datetime string") {
        str = "20111203101530"
        and("formatter is ISO datetime") {
            formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
            `when`("parse LocalDateTime form string and formatter") {
                actual = LocalDateTime.parse(str, formatter)
                then("actual should be LocalDateTime object") {
                    actual shouldBe LocalDateTime.of(2011, 12, 3, 10, 15, 30)
                }
            }
        }
    }
})
