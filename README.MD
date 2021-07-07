# Empik Microservices

This project contains microservices.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

Required software installed on your operating system:

```
1. Java 11
2. Maven
3. Git
4. Intellij IDEA
```

### Installing

```
1. Clone empik-microservices
2. Configure JDK and Maven
3. Download all maven dependencies
4. Run: mvn clean install
```

JAR should be created in target folder

## Users Service

### Running 'Users Service"


1. Run command in root folder: docker-compose up
2. Open swagger ui in browser: http://localhost:8081/swagger-ui/
3. Call /users/ endpoint for login e.g. octocat, lucas
4. Call /loginCallingNumber/ endpoint for checking number of executed API call for given login

Database checking from docker container level:

- docker exec -it users-postgres-db bash
- psql -U username -d usersdb
- \dt (shows all tables)
- SELECT * FROM login_calling;

or
- docker exec -it users-postgres-db bash
- psql -U username -d usersdb -c 'SELECT * FROM login_calling'


### Database
- For local development: H2
- For docker running: postgresql


### Info

Technical Info:
```
Architecture
- Microservices
- REST API
```

Technology
```
- Java 11
- Maven
- Spring Boot
- Spring Data JPA
- H2 Database
= PostGresSQL
- JUnit 5/Jupiter
- Mockito
- Docker
- OpenAPI 3.0/Swagger UI
- Lombok

Ports:
8081 - User Service (using H2)
8082 - User Service (using postgresql)