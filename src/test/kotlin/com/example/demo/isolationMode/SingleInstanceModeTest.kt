package com.example.demo.isolationMode

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FreeSpec
import java.util.*

class SingleInstanceModeTest : FreeSpec({
    isolationMode = IsolationMode.SingleInstance
    val that = this

    "a" - {
        println("a: $that")
        "b" - {
            println("b: $that")
            "c" {
                println("c: $that")
            }
        }
    }

    "d" - {
        println("d: $that")
        "e" - {
            println("e: $that")
            "f" {
                println("f: $that")
            }
        }
    }
})

class InstancePerTestModeTest : FreeSpec({
    isolationMode = IsolationMode.InstancePerTest
    val that = this

    "a" - {
        println("a: $that")
        "b" - {
            println("b: $that")
            "c" {
                println("c: $that")
            }
        }
    }

    "d" - {
        println("d: $that")
        "e" - {
            println("e: $that")
            "f" {
                println("f: $that")
            }
        }
    }
})

class InstancePerLeafTestModeTest : FreeSpec({
    isolationMode = IsolationMode.InstancePerLeaf
    val that = this

    "a" - {
        println("a: $that")
        "b" - {
            println("b: $that")
            "c" {
                println("c: $that")
            }
        }
    }

    "d" - {
        println("d: $that")
        "e" - {
            println("e: $that")
            "f" {
                println("f: $that")
            }
        }
    }
})