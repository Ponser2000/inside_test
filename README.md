[![Codacy Badge](https://app.codacy.com/project/badge/Grade/a68b123692e44b5a822fff8f1a505948)](https://www.codacy.com/gh/Ponser2000/inside_test/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Ponser2000/inside_test&amp;utm_campaign=Badge_Grade)

### Описание

RESTful приложение на Spring Boot.

Данное приложение позволяет пройти аутентификацию пользователя в приложении,
в случае успеха пользователю будет выдан token<br>
Для прохождения аутентификация пользователя необходимо послать POST запрос по адресу

http://localhost:8080/authenticate

вида

```json
{
   "name": "имя отправителя",
   "password": "пароль"
}
```
В БД предварительно внесены два пользователя `user1:password1`,`user2:password2`

В дальнейшем, авторизованный пользователь сможет добавить сообщение или просмотреть историю сообщений (последние 10 сообщений)

Для добавления сообщения необходимо послать запрос по адресу 

http://localhost:8080/message

вида
```json
{
   "name":       "имя отправителя",
   "message":    "текст сообщение"
}
```
В случае, если "имя отправителя" не совпадет с текущим именем пользователя, то переданное сообщение не будет добавлено.

Для просмотра последних 10 сообщений необходимо послать запрос по адресу

http://localhost:8080/message

вида
```json
{
   "name":       "имя отправителя",
   "message":    "history 10"
}
```
В результате запроса будут выданы сообщения из БД текущего пользователя



### Подготовка контейнера приложения
1. build JAR package
   - mvn clean package
2. build docker image
   - docker build -t inside_docker_sample

### Запуск приложения
   a. (Вариант 1) Запуск в консоли
   - docker run inside_docker_sample -p 8080:8080 -d

   b. (Вариант 2) Через composer
   - docker-composer up -d
      

