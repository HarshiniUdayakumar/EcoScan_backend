# Step 1: Use official OpenJDK 17
FROM openjdk:17-jdk

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy Maven wrapper and pom.xml first
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Step 4: Download dependencies offline
RUN ./mvnw dependency:go-offline -B

# Step 5: Copy the rest of the source code
COPY src ./src

# Step 6: Package Spring Boot app
RUN ./mvnw clean package -DskipTests

# Step 7: Set environment variables for MySQL (to read from Render)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://<RAILWAY_HOST>:3306/<DB_NAME>
ENV SPRING_DATASOURCE_USERNAME=<DB_USER>
ENV SPRING_DATASOURCE_PASSWORD=<DB_PASSWORD>
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_SHOW_SQL=true

# Step 8: Run the Spring Boot app
CMD ["java", "-jar", "target/eco_backend-0.0.1-SNAPSHOT.jar"]
