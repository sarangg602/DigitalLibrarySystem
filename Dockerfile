# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk

# Set working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/DigitalLibrarySystem-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (default for Spring Boot is 8080)
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "app.jar"]
