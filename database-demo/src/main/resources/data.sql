create table Person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);

insert into Person (id,name,location,birth_date) values(10001,'Subhasish','Bangalore',sysdate());
insert into Person (id,name,location,birth_date) values(10002,'Ankit','Berlin',sysdate());
insert into Person (id,name,location,birth_date) values(10003,'Anirban','Pune',sysdate());
insert into Person (id,name,location,birth_date) values(10004,'Saurav','Giwahati',sysdate());
