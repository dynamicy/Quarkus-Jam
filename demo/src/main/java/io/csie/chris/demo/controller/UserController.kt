package io.csie.chris.demo.controller

import io.csie.chris.demo.response.ApiResponse
import io.csie.chris.demo.service.UserService
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "User Controller", description = "API for managing users")
class UserController {

    @Inject
    lateinit var userService: UserService

    @POST
    @Operation(summary = "Add a new user", description = "Add a new user with name and email")
    fun addUser(@QueryParam("name") name: String, @QueryParam("email") email: String): Response {
        val user = userService.addUser(name, email)
        val response = ApiResponse(true, "User added successfully", user)
        return Response.ok(response).build()
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a user", description = "Delete a user by ID")
    fun deleteUser(@PathParam("id") id: String): Response {
        userService.deleteUser(id)
        val response = ApiResponse<Void>(true, "User deleted successfully", null)
        return Response.ok(response).build()
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get a user", description = "Get a user by ID")
    fun getUserById(@PathParam("id") id: String): Response {
        val user = userService.getUserById(id)
        val response = ApiResponse(true, "User retrieved successfully", user)
        return Response.ok(response).build()
    }

    @GET
    @Operation(summary = "Get all users", description = "Get all users")
    fun getAllUsers(): Response {
        val users = userService.getAllUsers()
        val response = ApiResponse(true, "Users retrieved successfully", users)
        return Response.ok(response).build()
    }
}