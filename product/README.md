# Product Microservice

A Spring Boot microservice for managing products.

## Features

- REST CRUD API for products
- Data persistence with Spring Data JPA
- PostgreSQL integration
- Maven build

## Quick Start

### 1. Start PostgreSQL

```bash
cd /Users/angsh/Desktop/JavaCode/project/product
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

The service runs on `http://localhost:8081`

## API Endpoints

- `POST /api/products` - Create product
- `GET /api/products` - List all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/number/{productNumber}` - Get product by product number
- `GET /api/products/search?name={name}` - Search products by name
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

## Database

Configured for PostgreSQL on `jdbc:postgresql://localhost:5432/product_db`.

## Notes

- The service uses Java 17 and Spring Boot 4.0.6.
- Update `src/main/resources/application.yaml` if you need to change DB credentials or port.
