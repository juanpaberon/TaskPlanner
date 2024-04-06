DROP DATABASE IF EXISTS `taskPlannerTest`;
CREATE DATABASE IF NOT EXISTS taskPlannerTest 
    DEFAULT CHARACTER SET utf8mb4 
    DEFAULT COLLATE utf8mb4_unicode_ci;
USE taskPlannerTest;

CREATE TABLE `Task` (
	ID int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    parentTaskID int NULL,
    `description` varchar(200) NULL,
    timeCreated DATETIME NOT NULL,
    dueTime TIME NULL,
    dueDate DATE NULL,
    PRIMARY KEY (ID)
);