# Используем официальный образ OpenJDK для запуска приложения
FROM openjdk:17-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл сборки приложения в рабочую директорию
COPY target/studentmanagement-0.0.1-SNAPSHOT.jar studentmanagement.jar

# Устанавливаем команду для запуска приложения при старте контейнера
ENTRYPOINT ["java", "-jar", "studentmanagement.jar"]
