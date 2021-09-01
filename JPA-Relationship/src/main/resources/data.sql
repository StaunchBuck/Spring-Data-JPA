insert into course_details(id, name,last_updated_date, created_date) values(10001,'JPA with Hibernate1',sysdate(),sysdate());
insert into course_details(id, name,last_updated_date, created_date) values(10002,'JPA with Hibernate2',sysdate(),sysdate());
insert into course_details(id, name,last_updated_date, created_date) values(10003,'JPA with Hibernate3',sysdate(),sysdate());
insert into course_details(id, name,last_updated_date, created_date) values(10004,'JPA with Hibernate4',sysdate(),sysdate());

insert into passport(id, number) values(40001,'E1234H');
insert into passport(id, number) values(40002,'Y4937S');
insert into passport(id, number) values(40003,'I7865B');

insert into student(id, name, passport_id) values(20001,'Ranga',40001);
insert into student(id, name, passport_id) values(20002,'Adam',40002);
insert into student(id, name, passport_id) values(20003,'Jane',40003);

insert into review(id, rating, description) values(50001,'5','Great Course');
insert into review(id, rating, description) values(50002,'5','Wonderful Course');
insert into review(id, rating, description) values(50003,'5','Awsome Course');