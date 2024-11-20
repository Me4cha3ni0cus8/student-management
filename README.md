# Инструкция по развёртыванию проекта
## Программное обеспечение:
Интегрированная среда разработки
Docker

1. Клонируйте репозитарий
2. Откройте терминал:

  2.1) Введите ```sh cd C:\{cloned_project_path} ```
  
  2.2) Введите команду ```sh docker compose up ```

## Примеры запросов в формате CURL (Windows cmd):

  Получение	списка объектов студентов
  ```sh
curl -X GET http://localhost:8080/students -H "Authorization: Bearer {your_jwt}"
```
Добавление новой сущности студента
```sh
curl -X POST http://localhost:8080/students -H "Authorization: Bearer {your_jwt}" -H "Content-Type: application/json" -d "{\"firstName\": \"Anna\", \"lastName\": \"Ivanova\", \"middleName\": \"Arkadievna\", \"group\": \"A1\", \"averageScore\": 4.5}"
```
Изменение сущности объекта студента
```sh
curl -X PUT http://localhost:8080/students/{unique_mongodb_id} -H "Authorization: Bearer {your_jwt}" -H "Content-Type: application/json" -d "{\"firstName\": \"Anna\", \"lastName\": \"Karenina\", \"middleName\": \"Arkadievna\", \"group\": \"A1\", \"averageScore\": 5.0}"
```
Удаление объекта студента
```sh
curl -X DELETE http://localhost:8080/students/{unique_mongodb_id} -H "Authorization: Bearer {your_jwt}"
```


