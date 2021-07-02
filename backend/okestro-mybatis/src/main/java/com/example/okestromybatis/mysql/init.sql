
show databases;

create database member;

create database myjpa_db;

use mybatis_db;
use puppy;
use myjpa_db;

show tables;

create table member(
                       id int auto_increment key,
                       name varchar(255)
);


select * from user;
select * from company;
select * from member;

insert into member(name) values("spring");



SET SQL_SAFE_UPDATES=0;
Update user SET email = "admin@naver.com";
Update user SET email = "jsp@naver.com" where user_id = 1;
Update user SET password = 1234 where user_id = 2;


-- 삭제 --
drop table member;