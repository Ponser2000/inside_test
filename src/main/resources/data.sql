DELETE FROM reports;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, password, role)
VALUES ('user1', 'password1', 'USER'),
       ('user2', 'password2', 'USER');

INSERT INTO reports (date_time, message, user_id)
VALUES ('2021-06-24 08:00:00','message1 user1',100000),
       ('2021-07-24 08:00:00','message2 user1',100000),
       ('2021-06-24 08:00:00','message1 user2',100001);