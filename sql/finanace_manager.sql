CREATE DATABASE IF NOT exists finance_manager;
use finance_manager;

create table transactions(id int auto_increment PRIMARY KEY, type varchar(10) not null, amount decimal(10,2) not null,category varchar(50), description varchar(255),date DATE not null);

