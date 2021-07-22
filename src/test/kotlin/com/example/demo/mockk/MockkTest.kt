package com.example.demo.mockk

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import java.util.*

internal class MockkTest : FunSpec({
    val repository = mockk<FooRepository>()
    val sut = FooService(repository)

    test("save test") {
        val foo = Foo(id = UUID.randomUUID().toString(), title = UUID.randomUUID().toString())
        every { repository.save(foo) } just Runs

        sut.save(foo)

        verify { repository.save(foo) }
    }

    test("get by id test") {
        val id = UUID.randomUUID().toString()
        val foo = Foo(id = UUID.randomUUID().toString(), title = UUID.randomUUID().toString())
        every { repository.findById(id) } returns Optional.of(foo)

        val actual = sut.getById(id)

        actual shouldBe foo
    }
})

internal class FooService(private val repository: FooRepository) {
    fun save(data: Foo) {
        repository.save(data)
    }
    fun getById(id: String): Foo {
        return repository.findById(id).orElseThrow()
    }
}

interface FooRepository {
    fun save(data: Foo)
    fun findById(id: String): Optional<Foo>
}

data class Foo(
    val id: String,
    val title: String,
)