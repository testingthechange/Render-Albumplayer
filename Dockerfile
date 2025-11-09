# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven config and source
COPY pom.xml .
COPY src ./src

# Build the Spring Boot jar
RUN mvn -q -DskipTests package

# ---- Run stage ----
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/album-player-0.0.1-SNAPSHOT.jar app.jar

# Render exposes port 10000 to the outside world.
# Tell Spring Boot to listen on that same port.
ENV SERVER_PORT=10000
EXPOSE 10000

# Run the app
CMD ["java", "-jar", "app.jar"]
