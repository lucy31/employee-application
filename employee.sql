
create database if not exists employee_crud;

use employee_crud;

drop table if exists employee;

create table employee (
	eid int(11) not null auto_increment,
	ename varchar(45) default null,
	age int(11) default null,
	salary decimal(10,2) default null,
    	designation varchar(45) default null,
    	primary key(eid)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

select * from employee_crud.employee;

insert into employee_crud.employee values (1001, 'Manish Jain', 23, 23000.00, 'Junior Developer');
insert into employee_crud.employee values (1002, 'Ganesh Murthy', 42, 93000.00, 'Manager');
insert into employee_crud.employee values (1003, 'Anjali Mittal', 37, 53000.00, 'Senior Developer');
insert into employee_crud.employee values (1004, 'Suresh Ganpathy', 33, 27000.00, 'Developer');
insert into employee_crud.employee values (1005, 'Mukesh Tyagi', 25, 23000.00, 'Junior Developer');
