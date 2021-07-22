package com.example.demo.assertions

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldBeLowerCase
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.assertThrows

class AssertionsTest : StringSpec({
    "simple matchers test" {
        "".length.shouldBe(0)
        "".length shouldBe 0

        "a".shouldNotBe("")
        "a" shouldNotBe ""

        val numbers = listOf(1, 2, 3, 4, 5)
        numbers.shouldContain(3)
        numbers shouldContain 3

        numbers.shouldContainAll(listOf(1, 2, 3, 4, 5))
        numbers shouldContainAll listOf(1, 2, 3, 4, 5)

        "hello kotest".shouldStartWith("hello")
        "hello kotest" shouldStartWith "hello"

        "hello kotest".shouldEndWith("kotest")
        "hello kotest" shouldEndWith "kotest"
    }

    "multitude of matchers test" {
        val imageUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
        imageUrl.shouldContain("google")
            .shouldStartWith("https")
            .shouldEndWith(".png")
            .shouldBeLowerCase()
    }

    "exceptions test" {
        assertThrows<NumberFormatException> {
            "test".toInt()
        }

        val actual = assertThrows<Exception> {
            throw Exception("test message")
        }
        actual.message shouldBe "test message"
    }

    "soft assertions test" {
        val sut = Person(
            name = "james",
            age = 30,
            email = "test@gmail.com",
            phone = "010-1111-2222"
        )

        assertSoftly(sut) {
            name shouldBe "james"
            age shouldBe 30
            email shouldBe "test@gmail.com"
            phone shouldBe "010-1111-2222"
        }
    }
})

class Person(
    val name: String,
    val age: Int,
    val email: String,
    val phone: String,
)