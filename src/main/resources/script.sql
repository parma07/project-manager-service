CREATE DATABASE taskmanagerdb;

USE taskmanagerdb;

INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject)
VALUES('taskmanagerdb','localhost',PASSWORD('taskmanagerdb'),'','','');

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON taskmanagerdb.* to taskmanagerdb@localhost;

FLUSH PRIVILEGES;

create table users(
user_id INT AUTO_INCREMENT,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
employee_id VARCHAR(100) NOT NULL,
PRIMARY KEY (user_id)
);

create table parent_task(
   parent_id INT NOT NULL AUTO_INCREMENT,
   parent_task VARCHAR(100) NOT NULL,
   PRIMARY KEY (parent_id)
);

create table project(
project_id INT NOT NULL AUTO_INCREMENT,
project VARCHAR(100),
start_date DATE,
end_date DATE,
priority VARCHAR(100),
manager INT,
status VARCHAR(100) NULL DEFAULT 'ACTIVE',
PRIMARY KEY (project_id)
);

create table task(
   task_id INT NOT NULL AUTO_INCREMENT,
   parent_id INT,
   task_name VARCHAR(100) NOT NULL,
   priority VARCHAR(100) NOT NULL,
   edit_enabled VARCHAR(1), 
   start_date DATE,
   end_date DATE,
   project_id INT,
   user_id INT,
   status VARCHAR(100) NULL DEFAULT 'OPEN',
   PRIMARY KEY (task_id)
);











ALTER TABLE `taskmanagerdb`.`project` ADD COLUMN `status` VARCHAR(45) NOT NULL DEFAULT 'ACTIVE' AFTER `manager`;