package com.example.demo.spring

import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Service

@SpringBootTest(classes = [FooService::class])
internal class SpringTest(fooService: FooService) : FunSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        test("getFoo test") {
            val actual = fooService.getFoo()
            actual shouldBe Foo("id", "foo")
        }
    }
}

// class GlobalProjectConfig : AbstractProjectConfig() {
//    override fun extensions() = listOf(SpringExtension)
// }

@Service
class FooService {
    fun getFoo(): Foo {
        return Foo("id", "foo")
    }
}

data class Foo(
    val id: String,
    val title: String,
)
