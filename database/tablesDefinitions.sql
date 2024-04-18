DROP DATABASE IF EXISTS `taskPlanner`;
CREATE DATABASE IF NOT EXISTS taskPlanner 
    DEFAULT CHARACTER SET utf8mb4 
    DEFAULT COLLATE utf8mb4_unicode_ci;
USE taskPlanner;

CREATE TABLE `Task` (
	ID int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    parentTaskID int NULL,
    `description` bool NOT NULL,
    timeCreated DATETIME NOT NULL,
    dueTime TIME NULL,
    dueDate DATE NULL,
    timeFinished DATETIME NULL,
    PRIMARY KEY (ID)
);