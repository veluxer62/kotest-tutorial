package com.example.demo.propertyTesting

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.next
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

internal class GeneratorTest : StringSpec({
    "toString returns class properties using checkAll" {
        checkAll(barArb) { bar ->
            bar.id shouldBeLessThan 20
            bar.title.length shouldBeGreaterThanOrEqualTo 5
            bar.title.length shouldBeLessThanOrEqual 30
        }
    }
})

val barArb = arbitrary { rs ->
    val id = Arb.int(0, 19).next(rs)
    val title = Arb.string(5, 30).next(rs)
    Bar(id, title)
}

data class Bar(val id: Int, val title: String) {
    init {
        require(id < 20)
        require(title.length in 5..30)
    }
}