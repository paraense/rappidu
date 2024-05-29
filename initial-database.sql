CREATE DATABASE IF NOT EXISTS rappidu;

USE rappidu;

CREATE TABLE IF NOT EXISTS PRODUCTS (
    ID BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(50),
    PRICE DECIMAL(5,2),
    TYPE TINYINT(4) NOT NULL
);

CREATE TABLE IF NOT EXISTS CUSTOMERS (
    ID BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(50),
    CPF VARCHAR(11)
);

CREATE TABLE IF NOT EXISTS ORDERS (
    ID BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    CUSTOMER_NAME VARCHAR(50),
    AMOUNT DECIMAL(5,2),
    STATUS VARCHAR(20)
 );

CREATE TABLE IF NOT EXISTS ITEMS (
    ID BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(50),
    AMOUNT DECIMAL(5,2),
    CUSTOMS VARCHAR(100),
    ORDER_ID BIGINT UNSIGNED,
    CONSTRAINT FK_ORDER_ID FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID)
);

CREATE TABLE IF NOT EXISTS ADDRESSES (
    ID BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    STREET VARCHAR(50),
    NEIGHBORHOOD VARCHAR(50),
    CITY VARCHAR(50),
    ZIPCODE VARCHAR(8),
    STATE VARCHAR(50),
    CUSTOMER_ID BIGINT UNSIGNED,
    CONSTRAINT FK_CONSUMER_ID FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(ID)
);

INSERT INTO PRODUCTS (name,price,type)
VALUES  ('Hamburguer Vegetariano', 45.90,0),
        ('Milkshake', 25.90,3),
        ('Pudim', 15.90,3),
        ('X-Burguer', 45.90,0),
        ('Coca-cola', 25.90,2),
        ('Sorvete', 15.90,3),
        ('Pizza Grande', 45.90,0),
        ('Batata Frita', 25.90,1),
        ('Agua sem gás', 15.90,2);