# Use an official OpenJDK runtime as the base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container at /app
COPY target/OrangeHRMAutomation-1.0.0.jar .

# Expose the application port (optional, replace 8080 with your app's port if different)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "OrangeHRMAutomation-1.0.0.jar"]
