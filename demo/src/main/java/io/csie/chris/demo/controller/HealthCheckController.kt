package io.csie.chris.demo.controller

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.config.inject.ConfigProperty
import java.time.LocalDateTime

@Path("/health")
class HealthCheckController {

    @ConfigProperty(name = "quarkus.application.name")
    lateinit var appName: String

    @ConfigProperty(name = "app.version")
    lateinit var appVersion: String

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun checkHealth(): Response {
        val response = mapOf(
            "status" to "UP",
            "timestamp" to LocalDateTime.now().toString(),
            "appName" to appName,
            "appVersion" to appVersion
        )
        return Response.ok(response).build()
    }
}