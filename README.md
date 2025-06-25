# Spring Boot User API (In-Memory CRUD)

A simple Spring Boot project demonstrating CRUD operations using an in-memory `Map<Integer, User>`.

## Endpoints

| Method | Endpoint         | Description        |
|--------|------------------|--------------------|
| POST   | `/users`         | Create a user      |
| GET    | `/users/{id}`    | Get user by ID     |
| PUT    | `/users/{id}`    | Update user        |
| DELETE | `/users/{id}`    | Delete user        |

## Features
- No database required
- Swagger UI enabled
- Custom exception handling

## Run the app

```bash
mvn spring-boot:run
