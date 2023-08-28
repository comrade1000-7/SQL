CREATE TABLE PERSONS (
     name VARCHAR(50) NOT NULL,
     surname VARCHAR(50) NOT NULL,
     age INT NOT NULL,
     phone_number VARCHAR(12),
     city_of_living VARCHAR(50),
     PRIMARY KEY (name, surname, age)
);

INSERT INTO PERSONS
VALUES ('IVAN', 'PETROV', 29, '799966677700', 'MOSCOW'),
       ('IVAN', 'SIDOROV', 45, '78887773344', 'SPB'),
       ('PETR', 'SMIRNOV', 26, '79997834545', 'MOSCOW'),
       ('SEMEN', 'VORONOV', 33, '78886663341', 'MOSCOW'),
       ('KIRILL', 'BABAEV', 49, '78881113344', 'SPB');

SELECT name, surname
FROM PERSONS
WHERE city_of_living = 'MOSCOW';

SELECT *
FROM PERSONS
WHERE age > 27
ORDER BY age DESC;