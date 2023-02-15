CREATE DATABASE inventorydb IF NOT EXISTS;
USE inventorydb;

DROP TABLE IF EXISTS [inventorydb.Products,inventorydb.Orders,inventorydb.Users];

CREATE TABLE inventorydb.Products (
    ID  INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL,
    PRICE FLOAT(2) NOT NULL DEFAULT 0.00,
    QUANTITY INT DEFAULT 0,
    DESCRIPTION TEXT)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE inventorydb.Orders (
    ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(30) NOT NULL,
    TOTAL FLOAT(2) DEFAULT 0.00,
    QUANTITY INT DEFAULT 0,
    CHECKEDOUT BOOLEAN DEFAULT 0
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE inventorydb.Users (
    ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(30) NOT NULL,
    PASSWORD VARCHAR(30) NOT NULL,
    EMAIL VARCHAR(40) NOT NULL DEFAULT "newuser@shop.com",
    IsAdmin BOOLEAN DEFAULT 0
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
 