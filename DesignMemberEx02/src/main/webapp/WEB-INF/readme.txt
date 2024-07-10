create table member (
seq int not null primary key,
-- unique
id varchar(10) not null,
password varchar(41) not null,
name varchar(10) not null,
gender char(1),
birth varchar(30),
mail varchar(30),
-- 국제 
phone char(13),
address varchar(50),
regist_day varchar(50),
);