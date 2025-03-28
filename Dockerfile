# Use official Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Set the JAR file path (update name if different)
CMD ["java", "-jar", "target/DigitalLibrarySystem-0.0.1-SNAPSHOT.jar"]
