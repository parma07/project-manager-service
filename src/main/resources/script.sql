CREATE DATABASE taskmanager;

USE taskmanager;

INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject)
VALUES('taskmanager','localhost',PASSWORD('taskmanager'),'','','');

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON taskmanager.* to taskmanager@localhost;

FLUSH PRIVILEGES;

create table task(
   task_id INT NOT NULL AUTO_INCREMENT,
   parent_id INT,
   task_name VARCHAR(100) NOT NULL,
   priority VARCHAR(100) NOT NULL,
   edit_enabled VARCHAR(1), 
   start_date DATE,
   end_date DATE,
   PRIMARY KEY (task_id)
);

create table parent_task(
   parent_id INT NOT NULL AUTO_INCREMENT,
   parent_task VARCHAR(100) NOT NULL,
   PRIMARY KEY (parent_id)
);

alter table task add column project_id INT;
alter table task add column status VARCHAR(100);

create table project(
project_id INT NOT NULL AUTO_INCREMENT,
project VARCHAR(100),
start_date DATE,
end_date DATE,
priority VARCHAR(100),
manager INT,
status VARCHAR(100),
PRIMARY KEY (project_id)
);

create table users(
user_id INT AUTO_INCREMENT,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
employee_id VARCHAR(100) NOT NULL,
project_id INT,
task_id INT,
PRIMARY KEY (user_id)
);

ALTER TABLE `taskmanagerdb`.`project` ADD COLUMN `status` VARCHAR(45) NOT NULL DEFAULT 'ACTIVE' AFTER `manager`;