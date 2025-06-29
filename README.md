# Simple E-Commerce Backend

A simple backend system for managing products and orders, built with Spring Boot and MySQL.  
Includes JWT-based authentication, Swagger UI, and Docker support.

## 🔧 Tech Stack

- Java 17
- Spring Boot 3.x
- MySQL
- Spring Security (JWT)
- Swagger/OpenAPI
- Docker & Docker Compose

## ✅ Features

- RESTful API (Spring Boot)
- MySQL Module: User / Product / Order
- PostgreSQL Module: PgReview demo (separate datasource)
- Thrift Module: CouponService (via RPC, independent Docker service)
- JWT Authentication (Spring Security)
- Swagger/OpenAPI Docs
- Dockerized: docker-compose for MySQL & PostgreSQL
- Clean project structure (multi-package separation)
- Postman collection provided
- External API Integration: Dynamic weather query by coordinates (Open-Meteo)

## 🚀 How to Run
**Note:** The `docker-compose.yml` file has been removed from this project.
### The following operation can be ignored .
```bash
git clone git@github.com:qingfan007/ecommerce.git
cd ecommerce
docker-compose up -d


# start
docker-compose up -d

# check status
docker-compose ps

# cat logs
docker-compose logs -f web

# test
curl http://localhost:8080

# stop
docker-compose down

# rebulid image and start
docker-compose up -d --build

