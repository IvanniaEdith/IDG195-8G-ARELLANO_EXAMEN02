package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Authentication) {
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    routing {

        get("/ventas") {
            call.respondText("bolsas = 1, goma = 5 ", contentType = ContentType.Text.Plain)
        }

        get("/json/mundo") {
            call.respond(mapOf("Buenas" to "tardes"))
        }
    }

    routing {

        get("/productos") {
            call.respondText("bolsas, goma", contentType = ContentType.Text.Plain)
        }

        get("/json/hola") {
            call.respond(mapOf("Buenas" to "tardes"))
        }
    }
}

