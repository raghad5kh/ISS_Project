DROP DATABASE IF EXISTS iss_project;
CREATE DATABASE iss_project;
USE iss_project;
CREATE TABLE students (
  id INT(15) PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(30),
  password VARCHAR(8),
  address VARCHAR(30) DEFAULT  NULL,
  phone_number INT(15) DEFAULT  NULL,
  mobile_number INT(15) DEFAULT  NULL


);
CREATE TABLE professor (
  id INT(15) PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(30),
  password VARCHAR(8),
  address VARCHAR(30) DEFAULT NULL,
  phone_number INT(15) DEFAULT NULL,
  mobile_number INT(15) DEFAULT NULL

);
CREATE TABLE list_stu_id (
  id INT(15) PRIMARY KEY AUTO_INCREMENT,
  id_number INT(15)
);

CREATE TABLE list_pro_id (
  id INT(15) PRIMARY KEY AUTO_INCREMENT,
  id_number INT(15)
);

INSERT INTO list_stu_id(id_number) VALUES (53221);
INSERT INTO list_stu_id(id_number) VALUES (53222);
INSERT INTO list_pro_id(id_number) VALUES (53223);
INSERT INTO list_pro_id(id_number) VALUES (53224);