# Инструкция по развёртыванию проекта
Программное обеспечение:
IntelliJ IDEA
Docker

1. Клонируйте репозитарий https://github.com/Me4cha3ni0cus8/student-management.git в IntelliJ IDEA
2. Запустите терминал, перейдите в директорию, где находится файл docker-compose.yml и запустить команду docker-compose up -d 

Примеры запросов в формате CURL:
  Windows (cmd):
  Получение	списка объектов студентов
  ```sh
curl -X GET http://localhost:8080/students
```
Добавление новой сущности студента
```sh
curl -X POST http://localhost:8080/students -H "Content-Type: application/json" -d "{\"firstName\":\"Andrei\",\"lastName\":\"Kruglow\",\"middleName\":\"Olegovich\",\"group\":\"A-11\",\"averageScore\":3.5}"
```
Изменение сущности объекта студента
```sh
curl -X PUT http://localhost:8080/students/673cf19d9ee80030c680b475 -H "Content-Type: application/json" -d "{\"firstName\":\"Andrei\",\"lastName\":\"Kruglow\",\"middleName\":\"Andreev\",\"group\":\"A-11\",\"averageScore\":4.7}"
```
Удаление объекта студента
```sh
curl -X DELETE "http://localhost:8080/students/673cf19d9ee80030c680b475"
```


