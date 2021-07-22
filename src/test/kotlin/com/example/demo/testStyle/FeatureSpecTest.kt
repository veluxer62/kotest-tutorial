package com.example.demo.testStyle

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

internal class FeatureSpecTest : FeatureSpec({
    feature("parse LocalDateTime") {
        scenario("should return LocalDateTime object when given string") {
            val str = "2011-12-03T10:15:30"
            val actual = LocalDateTime.parse(str)
            actual shouldBe LocalDateTime.of(2011, 12, 3, 10, 15, 30)
        }

        scenario("should return LocalDateTime object when given string and formatter") {
            val str = "20111203101530"
            val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
            val actual = LocalDateTime.parse(str, formatter)
            actual shouldBe LocalDateTime.of(2011, 12, 3, 10, 15, 30)
        }

        scenario("should throw Exception when given can't parse string") {
            val str = "test"
            shouldThrow<DateTimeParseException> {
                LocalDateTime.parse(str)
            }
        }
    }
})
