# Use official Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY . .

# Grant execute permissions to Maven wrapper
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port your app runs on (default for Spring Boot is 8080)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/DigitalLibrarySystem-0.0.1-SNAPSHOT.jar"]
