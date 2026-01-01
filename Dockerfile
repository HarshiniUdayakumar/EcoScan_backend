# Use an OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy the source code
COPY src src

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "target/eco_backend-0.0.1-SNAPSHOT.jar"]
