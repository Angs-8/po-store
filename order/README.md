# Order Microservice

A Spring Boot microservice for managing orders in the microservices architecture.

## Features

- **REST API**: Full CRUD operations for orders
- **Database**: PostgreSQL integration with Spring Data JPA
- **Entity Management**: Order entity with status tracking and timestamps
- **Service Layer**: Business logic isolation with OrderService
- **Error Handling**: Proper exception handling in controllers

## Prerequisites

- Java 17+
- Maven 3.8.0+
- Docker & Docker Compose (for PostgreSQL)

## Quick Start

### 1. Start PostgreSQL

```bash
docker-compose up -d
```

### 2. Build the Application

```bash
mvn clean package
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The service will start on `http://localhost:8082`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/orders` | Create a new order |
| GET | `/api/orders` | Get all orders |
| GET | `/api/orders/{id}` | Get order by ID |
| GET | `/api/orders/customer/{customerId}` | Get orders by customer ID |
| GET | `/api/orders/number/{orderNumber}` | Get order by order number |
| PUT | `/api/orders/{id}` | Update an order |
| DELETE | `/api/orders/{id}` | Delete an order |

## Example Request

```bash
curl -X POST http://localhost:8082/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "orderNumber": "ORD-001",
    "customerId": 1,
    "totalAmount": 99.99,
    "status": "PENDING"
  }'
```

## Project Structure

```
order/
├── src/
│   ├── main/
│   │   ├── java/com/explore/
│   │   │   ├── order/
│   │   │   │   └── OrderApplication.java
│   │   │   ├── controller/
│   │   │   │   └── OrderController.java
│   │   │   ├── entity/
│   │   │   │   └── Order.java
│   │   │   ├── service/
│   │   │   │   └── OrderService.java
│   │   │   └── repository/
│   │   │       └── OrderRepository.java
│   │   └── resources/
│   │       └── application.yaml
│   └── test/
└── build.gradle
```

## Configuration

Database connection settings in `application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/order_db
    username: postgres
    password: postgres
```

Change the `server.port` in `application.yaml` if needed (default: 8082).

## Running Tests

```bash
mvn test
```

## Stopping PostgreSQL

```bash
docker-compose down
```

## Technology Stack

- **Spring Boot 4.0.6**
- **Spring Data JPA**
- **PostgreSQL 15**
- **Maven 3.8.0+**
- **Lombok** (for reducing boilerplate)
- **JUnit 5**

## Notes

- The database is automatically created on first run
- Hibernate DDL is set to `update` mode - use with caution in production
- Timestamps are automatically managed for `created_at` and `updated_at` fields
