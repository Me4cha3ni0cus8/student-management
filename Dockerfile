## Используем официальный образ OpenJDK для запуска приложения
#FROM openjdk:17-slim
#
## Устанавливаем рабочую директорию внутри контейнера
#WORKDIR /app
#
## Копируем файл сборки приложения в рабочую директорию
#COPY target/studentmanagement-0.0.1-SNAPSHOT.jar studentmanagement.jar
#
## Устанавливаем команду для запуска приложения при старте контейнера
#ENTRYPOINT ["java", "-jar", "studentmanagement.jar"]

# Use a Maven image to build the application
FROM maven:3.9.9-amazoncorretto-23-alpine as builder

# Set the working directory inside the builder container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Package the application (runs mvn clean package)
RUN mvn clean package -DskipTests

# Use a lightweight Java runtime for running the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the runtime container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]