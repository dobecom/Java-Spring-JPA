## Java Spring JPA Project
This project demonstrates the use of Spring Boot 3.2 for building a simple Java application with JPA and other essential features.

## Version
- Java 17.0.7
- Spring Boot 3.2
- MySQL 8.0.36
- Gradle

## Project Contents
### Basic of REST API
- Exposes endpoints for CRUD operations on entities (ex: User, Product)
- Uses Spring Data JPA & Querydsl JPA for data access and request handling

### Configurations
1. Interceptors & Exception Filters
   - Logging and exception handling
2. Spring Security
   - JWT token-based authentication
3. JPA, Querydsl
   - Entity classes (ex: User, Product) with JPA repositories and Querydsl support for complex queries
4. Swagger (Springdoc)
   - API documentation available via Swagger UI (http://localhost:8080/docs/swagger-ui/index.html)

### Authorization & Authentication
1. Authentication
   - User registration and login
3. Authorization
   - Role-based authorization

### Request Validation
- Parameter validation using jakarta.validation annotations

### Test Code
- Unit and integration tests using JUnit 5

### Branches
- main : Practice for Spring Security, JPA
- basic-springboot3 : Basic Concepts of Spring Boot Project referenced by Udemy Course (https://www.udemy.com/course/spring-hibernate-tutorial/)
