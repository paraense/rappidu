CREATE DATABASE IF NOT EXISTS rappidu;

USE rappidu;

CREATE TABLE IF NOT EXISTS products(
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    price DECIMAL(5,2),
    type TINYINT(4) NOT NULL
);

INSERT INTO products(name,price,type)
VALUES  ('Hamburguer Vegetariano', 45.90,0),
        ('Milkshake', 25.90,3),
        ('Pudim', 15.90,3);