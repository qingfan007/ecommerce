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

## 🚀 How to Run

```bash
git clone https://github.com/qingfan007/ecommerce.git
cd ecommerce
docker-compose up -d


# 启动服务
docker-compose up -d

# 检查状态
docker-compose ps

# 查看日志
docker-compose logs -f web

# 测试接口
curl http://localhost:8080

# 停止服务
docker-compose down

# 重新构建镜像并启动
docker-compose up -d --build
# --build 强制重新构建镜像
