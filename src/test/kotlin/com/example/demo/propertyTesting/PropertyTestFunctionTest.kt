package com.example.demo.propertyTesting

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll
import io.kotest.property.forAll

internal class PropertyTestFunctionTest : StringSpec({
    "toString returns class properties using forAll" {
        forAll<Int, String> { id, title ->
            val sut = Foo(id, title)
            val actual = sut.toString()
            actual == "Foo(id=$id, title=$title)"
        }
    }

    "toString returns class properties using checkAll" {
        checkAll<Int, String> { id, title ->
            val sut = Foo(id, title)
            val actual = sut.toString()
            actual shouldBe "Foo(id=$id, title=$title)"
        }
    }
})

data class Foo(val id: Int, val title: String)