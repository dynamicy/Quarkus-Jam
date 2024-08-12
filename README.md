# Quarkus-Jam

## Overview

This project is built using Quarkus and Kotlin, designed to manage user data. It uses MongoDB as the database and provides a RESTful API for CRUD operations on user data. The project includes basic CRUD functionalities, a health check endpoint, and support for OpenAPI and Swagger UI.

## Project Structure
```
src
├── main
│   ├── docker
│   ├── java
│   │   └── io
│   │       └── csie
│   │           └── chris
│   │               └── demo
│   │                   ├── controller
│   │                   │   ├── HealthCheckController.kt
│   │                   │   └── UserController.kt
│   │                   ├── dto
│   │                   │   └── UserModel.kt
│   │                   ├── entity
│   │                   │   └── User.kt
│   │                   ├── exception
│   │                   │   ├── GlobalExceptionHandler.kt
│   │                   │   └── UserNotFoundException.kt
│   │                   ├── repository
│   │                   │   └── UserRepository.kt
│   │                   ├── response
│   │                   │   └── ApiResponse.kt
│   │                   ├── serializer
│   │                   │   └── ObjectIdSerializer.kt
│   │                   └── service
│   │                       └── UserService.kt
│   └── resources
│       └── application.properties
└── test
└── docker
```

## Key Features

### 1. Health Check

- **HealthCheckController**: Provides the `/health` endpoint to check the application's status.

### 2. User Management

- **UserController**: Handles all user-related operations through RESTful APIs.
  - `POST /api/users`: Add a new user.
  - `GET /api/users`: Retrieve all users.
  - `GET /api/users/{id}`: Retrieve a user by ID.
  - `DELETE /api/users/{id}`: Delete a user by ID.

### 3. Data Transfer Objects (DTO)

- **UserModel**: A data transfer object used to encapsulate user data and convert between entity and DTO.

### 4. MongoDB Integration

- **User**: The entity class representing a user in MongoDB. The `id` is automatically generated using `ObjectId`.
- **UserRepository**: Manages MongoDB operations for user data.

### 5. Exception Handling

- **GlobalExceptionHandler**: Handles exceptions globally, providing a standardized response structure.
- **UserNotFoundException**: A custom exception thrown when a user is not found.

### 6. API Response

- **ApiResponse**: A generic response structure for all API responses, including success status, message, data, and timestamp.

### 7. Serialization

- **ObjectIdSerializer**: Custom serializer for MongoDB `ObjectId` to handle JSON serialization.

## Getting Started

### Prerequisites

- Java 17 or higher
- Apache Maven or Gradle
- MongoDB instance

### Running the Application

1. **Build the project**:

   ```
   ./gradlew clean build
   ```
   
2.	Run the application:   
```
./gradlew quarkusDev
```
3.	Access the APIs:

	•	Health Check: 
	```
	http://localhost:8080/health
	```
	
	•	Swagger UI: 
	```
	http://localhost:8080/q/swagger-ui
	```
	
### Configuration

The application configuration is managed via the application.properties file located in the src/main/resources directory.	