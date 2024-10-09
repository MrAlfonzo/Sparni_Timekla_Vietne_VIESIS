# Izmanto Maven attēlu
FROM maven:3.8.7-eclipse-temurin-17 as build

# Iestata darba direktoriju konteinerī
WORKDIR /app

# Iekopē Maven projekta failus konteinerī
COPY pom.xml .
COPY src ./src

# Izveido JAR failu izlaižot testus
RUN mvn clean package -DskipTests


# Izmanto OpenJDK attēlu
FROM openjdk:17-jdk-alpine

# Norāda lietotnes izmantoto portu
EXPOSE 8080

# Definē JAR failu
ARG JAR_FILE=target/Sparni_Timekla_Vietne-0.0.1-SNAPSHOT.jar

# Iekopē JAR failu konteinerī izmantojot Maven
COPY --from=build /app/${JAR_FILE} sparni-timekla-vietne.jar

# Palaiž lietotni
ENTRYPOINT ["java", "-jar", "/sparni-timekla-vietne.jar"]