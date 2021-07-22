package com.example.demo.mockServer

import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.mockserver.MockServerListener
import io.kotest.matchers.shouldBe
import org.mockserver.client.MockServerClient
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import org.mockserver.model.JsonBody.json
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpStatus

class MockServerTest : FunSpec({
    val restTemplate = RestTemplateBuilder()
        .rootUri("http://localhost:8080")
        .build()

    listener(MockServerListener(8080))

    beforeTest {
        MockServerClient("localhost", 8080).`when`(
            HttpRequest.request()
                .withMethod("POST")
                .withPath("/foo")
                .withHeader("Content-Type", "application/json")
                .withBody(
                    json(
                        """{
                          "id" : "test-id",
                          "title" : "test-title"
                        }
                        """.trimIndent()
                    )
                )
        ).respond(
            HttpResponse.response()
                .withStatusCode(201)
        )
    }

    test("post test") {
        val actual = restTemplate.postForEntity(
            "/foo",
            Foo("test-id", "test-title"),
            Unit::class.java
        )
        actual.statusCode shouldBe HttpStatus.CREATED
    }
})

