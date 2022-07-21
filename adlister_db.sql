CREATE DATABASE IF NOT EXISTS adlister_db;

USE adlister_db;

CREATE TABLE IF NOT EXISTS user (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL ,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ads (
    id INT NOT NULL,
    user_id INT UNSIGNED NOT NULL ,
    title VARCHAR(50) NOT NULL,
    description text,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);




