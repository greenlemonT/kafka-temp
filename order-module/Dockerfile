# Base image
FROM openjdk:17-jdk-slim

# Application JAR file
ARG JAR_FILE=build/libs/*.jar

# Copy JAR file to container
COPY ${JAR_FILE} app.jar

# Expose port
EXPOSE 8081

# Run application
ENTRYPOINT ["java", "-jar", "/app.jar"]
