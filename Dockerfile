# Step 1: Build stage using a Maven image
FROM maven:3.8.7-eclipse-temurin-17 as build

# Set the working directory inside the container
WORKDIR /app

# Copy your Maven project files (pom.xml and source code) into the container
COPY pom.xml .
COPY src ./src

# Run Maven to clean and package the application (creates the JAR file)
RUN mvn clean package -DskipTests


# Step 1: Use an official OpenJDK image as the base
FROM openjdk:17-jdk-alpine

# Step 2: Expose the application port
EXPOSE 8080

# Step 3: Define a build argument for the JAR file
ARG JAR_FILE=target/Sparni_Timekla_Vietne-0.0.1-SNAPSHOT.jar

# Step 4: Copy the JAR file to the container (use the ARG variable)
COPY --from=build /app/${JAR_FILE} sparni-timekla-vietne.jar

# Step 5: Run the application
ENTRYPOINT ["java", "-jar", "/sparni-timekla-vietne.jar"]