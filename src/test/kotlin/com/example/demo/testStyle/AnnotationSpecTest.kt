package com.example.demo.testStyle

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class AnnotationSpecTest : AnnotationSpec() {
    @Test
    fun length_should_return_th_length_of_the_string() {
        val name = "hello kotest!"
        val actual = name.length
        actual shouldBe 13
    }
}
