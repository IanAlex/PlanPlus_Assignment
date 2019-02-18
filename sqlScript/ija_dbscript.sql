CREATE DATABASE ija_springrest;

USE ija_springrest;

CREATE TABLE Employee(
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `jobtitle` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`employeeid`)
);

