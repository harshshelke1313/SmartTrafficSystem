# Use an official Java runtime as a parent image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the whole project into the container
COPY . .

# Grant execute permission to the Maven wrapper
RUN chmod +x ./mvnw

# Package the application using Maven (skipping tests to make it faster)
RUN ./mvnw clean package -DskipTests

# Expose port 8080 so the internet can talk to it
EXPOSE 8080

# Run the application (using a wildcard in case the version number changes)
CMD ["sh", "-c", "java -jar target/*.jar"]