# ThriftyBackend
Backend service in Java Spring Boot for Thrifty Store.

Version: v0.1.1

## Local setup
Prerequisites:
- Java 17
- Maven
- Docker (for PostgreSQL)

Start the database from the repo root:
```bash
docker compose up -d db
```

Run the API:
```bash
mvn spring-boot:run
```

API endpoints:
- `GET http://localhost:8080/api/products?page=0&size=10`
- `GET http://localhost:8080/api/products/{id}`
