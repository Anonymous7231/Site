create database MyPage
use MyPage

create table Пользователи
(ID int not null identity(1,1),
Login varchar(100) not null,
Password varchar(100) not null,
constraint CS_PK primary key(ID),
constraint CS_Unique unique(Login))

INSERT INTO Пользователи(Login, Password) VALUES ('Anonymous', 'qwerty')