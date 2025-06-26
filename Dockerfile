FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /build

COPY . .

RUN mvn clean install -pl ecommerce -am -DskipTests


FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /build/ecommerce/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
