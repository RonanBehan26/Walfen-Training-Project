create table company (
	id bigint unsigned not null auto_increment, 
	name varchar(100),
	city varchar(200),
	primary key (id),
	unique key uk_company_name (name)
);

create table user (
	id bigint unsigned not null auto_increment, 
	first_name varchar(20),
	last_name varchar(20),
	primary key (id)
);

create table address (
	id bigint unsigned not null auto_increment, 
	street varchar(50),
	city varchar(50),
	country varchar(50),
	primary key (id)
);

create table employee ( 
	id bigint unsigned not null auto_increment, 
	first_name varchar(20),
	last_name varchar(20),
	company varchar(50),
	position varchar(50),
	primary key (id)
);

create table manager ( 
	id bigint unsigned not null auto_increment, 
	first_name varchar(20),
	last_name varchar(20),
	company varchar(50),
	birthday datetime not null,
	primary key (id)
);

