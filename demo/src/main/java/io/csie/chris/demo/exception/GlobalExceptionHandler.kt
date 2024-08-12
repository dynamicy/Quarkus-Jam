package io.csie.chris.demo.exception

import io.csie.chris.demo.response.ApiResponse
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class UserNotFoundExceptionHandler : ExceptionMapper<UserNotFoundException> {
    override fun toResponse(exception: UserNotFoundException): Response {
        val errorResponse = ApiResponse(false, exception.message ?: "User not found", null)
        return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build()
    }
}

@Provider
class GlobalExceptionHandler : ExceptionMapper<Exception> {
    override fun toResponse(exception: Exception): Response {
        val errorResponse = ApiResponse(false, exception.message ?: "Internal server error", null)
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build()
    }
}