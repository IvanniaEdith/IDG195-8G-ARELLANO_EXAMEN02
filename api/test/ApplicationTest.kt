package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {

    @Test
    fun testVenta() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/ventas").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    @Test
    fun testProducto() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/productos").apply {
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }


}
