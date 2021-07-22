package com.example.demo.isolationMode

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class DslTest : FreeSpec({
    isolationMode = IsolationMode.SingleInstance

    "some test" {
        "".length shouldBe 0
    }
})

internal class FunctionOverridesTest : FreeSpec() {
    override fun isolationMode() = IsolationMode.SingleInstance

    init {
        "some test" {
            "".length shouldBe 0
        }
    }
}

// object GlobalIsolationConfiguration : AbstractProjectConfig() {
//    override val isolationMode = IsolationMode.SingleInstance
// }
